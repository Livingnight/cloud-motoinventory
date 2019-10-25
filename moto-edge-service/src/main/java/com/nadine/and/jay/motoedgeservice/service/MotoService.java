package com.nadine.and.jay.motoedgeservice.service;

import com.nadine.and.jay.motoedgeservice.model.Motorcycle;
import com.nadine.and.jay.motoedgeservice.util.feign.MotoClient;
import com.nadine.and.jay.motoedgeservice.viewmodel.MotoViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class MotoService {
    private final BigDecimal SALES_TAX = new BigDecimal(".0675");
    private final BigDecimal DOC_FEES = new BigDecimal("234");
    private MotoClient motoClient;

    @Autowired
    public MotoService(MotoClient motoClient){
        this.motoClient = motoClient;
    }

    /**
     * fetches a list of all motos from the backing service through feign
     * @return List<MotoViewModel>
     */
    public List<MotoViewModel> fetchAllMotos(){
        List<Motorcycle> listFromFeign = motoClient.fetchAllMotos();
        List<MotoViewModel> listToReturn = new ArrayList<>();
        for (Motorcycle moto : listFromFeign){
            MotoViewModel motoViewModel = new MotoViewModel();
            motoViewModel.setId(moto.getId());
            motoViewModel.setPrice(moto.getPrice());
            motoViewModel.setMake(moto.getMake());
            motoViewModel.setModel(moto.getModel());
            motoViewModel.setYear(moto.getYear());
            motoViewModel.setColor(moto.getColor());
            listToReturn.add(motoViewModel);
        }
        return listToReturn;
    }

    /**
     * Returns the MotoViewModel with purchase info
     * @param motoViewModel
     * @return MotoViewModel
     */
    public MotoViewModel purchaseMoto(MotoViewModel motoViewModel){
        Motorcycle motoCheck = motoClient.fethMoto(motoViewModel.getId());
        if(motoCheck == null){
            return null;
        }



        motoViewModel.setSalesTax(SALES_TAX);
        motoViewModel.setDocFees(DOC_FEES);
        if(motoViewModel.getPrice().intValue() >= 9999){
            motoViewModel.setTranspoCost(new BigDecimal("499"));
        }else motoViewModel.setTranspoCost(new BigDecimal("395"));

        BigDecimal totalAfterTax =  motoViewModel.getPrice().multiply(SALES_TAX.add(new BigDecimal("1")));
        BigDecimal finalTotal = totalAfterTax.add(DOC_FEES).add(motoViewModel.getTranspoCost());
        motoViewModel.setTotalCost(finalTotal);
        return motoViewModel;
    }
}
