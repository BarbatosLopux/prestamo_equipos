package com.gestion.domain.service.acta;

import com.gestion.domain.repository.ActaRepostory;
import com.gestion.pesistence.entity.Acta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ActaServiceImpl implements ActaService{

    @Autowired
    private ActaRepostory actaRepostory ;
    @Override
    public List<Acta> listarActa() {
        return actaRepostory.findAll();
    }
}
