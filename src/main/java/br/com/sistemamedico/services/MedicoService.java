package br.com.sistemamedico.services;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class MedicoService {
    private static final String CRM_PATTERN = "^[0-9]{4,6}-[A-Z]{2}$";


    public static boolean validarCRM(String crm){
        if (crm == null || crm.isEmpty()) {
            return false;
        }

        return Pattern.matches(CRM_PATTERN, crm);
    }

}
