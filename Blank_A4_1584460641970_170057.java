/*
 * Generated by JasperReports - 17/03/20, 16:57
 */
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.fill.*;

import java.util.*;
import java.math.*;
import java.text.*;
import java.io.*;
import java.net.*;



/**
 *
 */
public class Blank_A4_1584460641970_170057 extends JREvaluator
{


    /**
     *
     */
    private JRFillParameter parameter_IS_IGNORE_PAGINATION = null;
    private JRFillParameter parameter_REPORT_CONNECTION = null;
    private JRFillParameter parameter_FILTER = null;
    private JRFillParameter parameter_JASPER_REPORT = null;
    private JRFillParameter parameter_REPORT_LOCALE = null;
    private JRFillParameter parameter_NumeroFattura = null;
    private JRFillParameter parameter_REPORT_TIME_ZONE = null;
    private JRFillParameter parameter_REPORT_TEMPLATES = null;
    private JRFillParameter parameter_REPORT_MAX_COUNT = null;
    private JRFillParameter parameter_REPORT_SCRIPTLET = null;
    private JRFillParameter parameter_JASPER_REPORTS_CONTEXT = null;
    private JRFillParameter parameter_REPORT_FORMAT_FACTORY = null;
    private JRFillParameter parameter_REPORT_PARAMETERS_MAP = null;
    private JRFillParameter parameter_REPORT_RESOURCE_BUNDLE = null;
    private JRFillParameter parameter_REPORT_DATA_SOURCE = null;
    private JRFillParameter parameter_REPORT_CONTEXT = null;
    private JRFillParameter parameter_REPORT_CLASS_LOADER = null;
    private JRFillParameter parameter_REPORT_VIRTUALIZER = null;
    private JRFillParameter parameter_SORT_FIELDS = null;
    private JRFillField field_Trattamento3 = null;
    private JRFillField field_DataFattura = null;
    private JRFillField field_NumeroFattura = null;
    private JRFillField field_Imponibile = null;
    private JRFillField field_Empap = null;
    private JRFillField field_TotaleFattura = null;
    private JRFillField field_CodiceFiscale = null;
    private JRFillField field_Trattamento = null;
    private JRFillField field_Via = null;
    private JRFillField field_Bollo = null;
    private JRFillField field_Capoluogo = null;
    private JRFillField field_NumeroCivico = null;
    private JRFillField field_Citta = null;
    private JRFillField field_Nome = null;
    private JRFillField field_CodicePostale = null;
    private JRFillField field_Cognome = null;
    private JRFillField field_Trattamento2 = null;
    private JRFillVariable variable_PAGE_NUMBER = null;
    private JRFillVariable variable_MASTER_CURRENT_PAGE = null;
    private JRFillVariable variable_MASTER_TOTAL_PAGES = null;
    private JRFillVariable variable_COLUMN_NUMBER = null;
    private JRFillVariable variable_REPORT_COUNT = null;
    private JRFillVariable variable_PAGE_COUNT = null;
    private JRFillVariable variable_COLUMN_COUNT = null;


    /**
     *
     */
    public void customizedInit(
        Map pm,
        Map fm,
        Map vm
        )
    {
        initParams(pm);
        initFields(fm);
        initVars(vm);
    }


    /**
     *
     */
    private void initParams(Map pm)
    {
        parameter_IS_IGNORE_PAGINATION = (JRFillParameter)pm.get("IS_IGNORE_PAGINATION");
        parameter_REPORT_CONNECTION = (JRFillParameter)pm.get("REPORT_CONNECTION");
        parameter_FILTER = (JRFillParameter)pm.get("FILTER");
        parameter_JASPER_REPORT = (JRFillParameter)pm.get("JASPER_REPORT");
        parameter_REPORT_LOCALE = (JRFillParameter)pm.get("REPORT_LOCALE");
        parameter_NumeroFattura = (JRFillParameter)pm.get("NumeroFattura");
        parameter_REPORT_TIME_ZONE = (JRFillParameter)pm.get("REPORT_TIME_ZONE");
        parameter_REPORT_TEMPLATES = (JRFillParameter)pm.get("REPORT_TEMPLATES");
        parameter_REPORT_MAX_COUNT = (JRFillParameter)pm.get("REPORT_MAX_COUNT");
        parameter_REPORT_SCRIPTLET = (JRFillParameter)pm.get("REPORT_SCRIPTLET");
        parameter_JASPER_REPORTS_CONTEXT = (JRFillParameter)pm.get("JASPER_REPORTS_CONTEXT");
        parameter_REPORT_FORMAT_FACTORY = (JRFillParameter)pm.get("REPORT_FORMAT_FACTORY");
        parameter_REPORT_PARAMETERS_MAP = (JRFillParameter)pm.get("REPORT_PARAMETERS_MAP");
        parameter_REPORT_RESOURCE_BUNDLE = (JRFillParameter)pm.get("REPORT_RESOURCE_BUNDLE");
        parameter_REPORT_DATA_SOURCE = (JRFillParameter)pm.get("REPORT_DATA_SOURCE");
        parameter_REPORT_CONTEXT = (JRFillParameter)pm.get("REPORT_CONTEXT");
        parameter_REPORT_CLASS_LOADER = (JRFillParameter)pm.get("REPORT_CLASS_LOADER");
        parameter_REPORT_VIRTUALIZER = (JRFillParameter)pm.get("REPORT_VIRTUALIZER");
        parameter_SORT_FIELDS = (JRFillParameter)pm.get("SORT_FIELDS");
    }


    /**
     *
     */
    private void initFields(Map fm)
    {
        field_Trattamento3 = (JRFillField)fm.get("Trattamento3");
        field_DataFattura = (JRFillField)fm.get("DataFattura");
        field_NumeroFattura = (JRFillField)fm.get("NumeroFattura");
        field_Imponibile = (JRFillField)fm.get("Imponibile");
        field_Empap = (JRFillField)fm.get("Empap");
        field_TotaleFattura = (JRFillField)fm.get("TotaleFattura");
        field_CodiceFiscale = (JRFillField)fm.get("CodiceFiscale");
        field_Trattamento = (JRFillField)fm.get("Trattamento");
        field_Via = (JRFillField)fm.get("Via");
        field_Bollo = (JRFillField)fm.get("Bollo");
        field_Capoluogo = (JRFillField)fm.get("Capoluogo");
        field_NumeroCivico = (JRFillField)fm.get("NumeroCivico");
        field_Citta = (JRFillField)fm.get("Citta");
        field_Nome = (JRFillField)fm.get("Nome");
        field_CodicePostale = (JRFillField)fm.get("CodicePostale");
        field_Cognome = (JRFillField)fm.get("Cognome");
        field_Trattamento2 = (JRFillField)fm.get("Trattamento2");
    }


    /**
     *
     */
    private void initVars(Map vm)
    {
        variable_PAGE_NUMBER = (JRFillVariable)vm.get("PAGE_NUMBER");
        variable_MASTER_CURRENT_PAGE = (JRFillVariable)vm.get("MASTER_CURRENT_PAGE");
        variable_MASTER_TOTAL_PAGES = (JRFillVariable)vm.get("MASTER_TOTAL_PAGES");
        variable_COLUMN_NUMBER = (JRFillVariable)vm.get("COLUMN_NUMBER");
        variable_REPORT_COUNT = (JRFillVariable)vm.get("REPORT_COUNT");
        variable_PAGE_COUNT = (JRFillVariable)vm.get("PAGE_COUNT");
        variable_COLUMN_COUNT = (JRFillVariable)vm.get("COLUMN_COUNT");
    }


    /**
     *
     */
    public Object evaluate(int id) throws Throwable
    {
        Object value = null;

        switch (id)
        {
            case 0 : 
            {
                value = new java.lang.Integer(1); //$JR_EXPR_ID=0$
                break;
            }
            case 1 : 
            {
                value = new java.lang.Integer(1); //$JR_EXPR_ID=1$
                break;
            }
            case 2 : 
            {
                value = new java.lang.Integer(1); //$JR_EXPR_ID=2$
                break;
            }
            case 3 : 
            {
                value = new java.lang.Integer(0); //$JR_EXPR_ID=3$
                break;
            }
            case 4 : 
            {
                value = new java.lang.Integer(1); //$JR_EXPR_ID=4$
                break;
            }
            case 5 : 
            {
                value = new java.lang.Integer(0); //$JR_EXPR_ID=5$
                break;
            }
            case 6 : 
            {
                value = new java.lang.Integer(1); //$JR_EXPR_ID=6$
                break;
            }
            case 7 : 
            {
                value = new java.lang.Integer(0); //$JR_EXPR_ID=7$
                break;
            }
            case 8 : 
            {
                value = ((java.lang.String)field_Cognome.getValue()); //$JR_EXPR_ID=8$
                break;
            }
            case 9 : 
            {
                value = ((java.lang.String)field_Capoluogo.getValue()); //$JR_EXPR_ID=9$
                break;
            }
            case 10 : 
            {
                value = ((java.lang.String)field_Citta.getValue()); //$JR_EXPR_ID=10$
                break;
            }
            case 11 : 
            {
                value = ((java.lang.String)field_Via.getValue()); //$JR_EXPR_ID=11$
                break;
            }
            case 12 : 
            {
                value = ((java.lang.String)field_NumeroCivico.getValue()); //$JR_EXPR_ID=12$
                break;
            }
            case 13 : 
            {
                value = ((java.lang.String)field_CodiceFiscale.getValue()); //$JR_EXPR_ID=13$
                break;
            }
            case 14 : 
            {
                value = ((java.lang.String)field_Nome.getValue()); //$JR_EXPR_ID=14$
                break;
            }
            case 15 : 
            {
                value = ((java.lang.String)field_CodicePostale.getValue()); //$JR_EXPR_ID=15$
                break;
            }
            case 16 : 
            {
                value = ((java.lang.String)field_DataFattura.getValue()); //$JR_EXPR_ID=16$
                break;
            }
            case 17 : 
            {
                value = ((java.lang.String)parameter_NumeroFattura.getValue()); //$JR_EXPR_ID=17$
                break;
            }
            case 18 : 
            {
                value = ((java.lang.String)field_Imponibile.getValue()); //$JR_EXPR_ID=18$
                break;
            }
            case 19 : 
            {
                value = ((java.lang.String)field_Empap.getValue()); //$JR_EXPR_ID=19$
                break;
            }
            case 20 : 
            {
                value = ((java.lang.String)field_Trattamento.getValue()); //$JR_EXPR_ID=20$
                break;
            }
            case 21 : 
            {
                value = ((java.lang.String)field_Trattamento2.getValue()); //$JR_EXPR_ID=21$
                break;
            }
            case 22 : 
            {
                value = ((java.lang.String)field_Trattamento3.getValue()); //$JR_EXPR_ID=22$
                break;
            }
            case 23 : 
            {
                value = ((java.lang.String)field_Bollo.getValue()); //$JR_EXPR_ID=23$
                break;
            }
            case 24 : 
            {
                value = ((java.lang.String)field_TotaleFattura.getValue()); //$JR_EXPR_ID=24$
                break;
            }
           default :
           {
           }
        }
        
        return value;
    }


    /**
     *
     */
    public Object evaluateOld(int id) throws Throwable
    {
        Object value = null;

        switch (id)
        {
            case 0 : 
            {
                value = new java.lang.Integer(1); //$JR_EXPR_ID=0$
                break;
            }
            case 1 : 
            {
                value = new java.lang.Integer(1); //$JR_EXPR_ID=1$
                break;
            }
            case 2 : 
            {
                value = new java.lang.Integer(1); //$JR_EXPR_ID=2$
                break;
            }
            case 3 : 
            {
                value = new java.lang.Integer(0); //$JR_EXPR_ID=3$
                break;
            }
            case 4 : 
            {
                value = new java.lang.Integer(1); //$JR_EXPR_ID=4$
                break;
            }
            case 5 : 
            {
                value = new java.lang.Integer(0); //$JR_EXPR_ID=5$
                break;
            }
            case 6 : 
            {
                value = new java.lang.Integer(1); //$JR_EXPR_ID=6$
                break;
            }
            case 7 : 
            {
                value = new java.lang.Integer(0); //$JR_EXPR_ID=7$
                break;
            }
            case 8 : 
            {
                value = ((java.lang.String)field_Cognome.getOldValue()); //$JR_EXPR_ID=8$
                break;
            }
            case 9 : 
            {
                value = ((java.lang.String)field_Capoluogo.getOldValue()); //$JR_EXPR_ID=9$
                break;
            }
            case 10 : 
            {
                value = ((java.lang.String)field_Citta.getOldValue()); //$JR_EXPR_ID=10$
                break;
            }
            case 11 : 
            {
                value = ((java.lang.String)field_Via.getOldValue()); //$JR_EXPR_ID=11$
                break;
            }
            case 12 : 
            {
                value = ((java.lang.String)field_NumeroCivico.getOldValue()); //$JR_EXPR_ID=12$
                break;
            }
            case 13 : 
            {
                value = ((java.lang.String)field_CodiceFiscale.getOldValue()); //$JR_EXPR_ID=13$
                break;
            }
            case 14 : 
            {
                value = ((java.lang.String)field_Nome.getOldValue()); //$JR_EXPR_ID=14$
                break;
            }
            case 15 : 
            {
                value = ((java.lang.String)field_CodicePostale.getOldValue()); //$JR_EXPR_ID=15$
                break;
            }
            case 16 : 
            {
                value = ((java.lang.String)field_DataFattura.getOldValue()); //$JR_EXPR_ID=16$
                break;
            }
            case 17 : 
            {
                value = ((java.lang.String)parameter_NumeroFattura.getValue()); //$JR_EXPR_ID=17$
                break;
            }
            case 18 : 
            {
                value = ((java.lang.String)field_Imponibile.getOldValue()); //$JR_EXPR_ID=18$
                break;
            }
            case 19 : 
            {
                value = ((java.lang.String)field_Empap.getOldValue()); //$JR_EXPR_ID=19$
                break;
            }
            case 20 : 
            {
                value = ((java.lang.String)field_Trattamento.getOldValue()); //$JR_EXPR_ID=20$
                break;
            }
            case 21 : 
            {
                value = ((java.lang.String)field_Trattamento2.getOldValue()); //$JR_EXPR_ID=21$
                break;
            }
            case 22 : 
            {
                value = ((java.lang.String)field_Trattamento3.getOldValue()); //$JR_EXPR_ID=22$
                break;
            }
            case 23 : 
            {
                value = ((java.lang.String)field_Bollo.getOldValue()); //$JR_EXPR_ID=23$
                break;
            }
            case 24 : 
            {
                value = ((java.lang.String)field_TotaleFattura.getOldValue()); //$JR_EXPR_ID=24$
                break;
            }
           default :
           {
           }
        }
        
        return value;
    }


    /**
     *
     */
    public Object evaluateEstimated(int id) throws Throwable
    {
        Object value = null;

        switch (id)
        {
            case 0 : 
            {
                value = new java.lang.Integer(1); //$JR_EXPR_ID=0$
                break;
            }
            case 1 : 
            {
                value = new java.lang.Integer(1); //$JR_EXPR_ID=1$
                break;
            }
            case 2 : 
            {
                value = new java.lang.Integer(1); //$JR_EXPR_ID=2$
                break;
            }
            case 3 : 
            {
                value = new java.lang.Integer(0); //$JR_EXPR_ID=3$
                break;
            }
            case 4 : 
            {
                value = new java.lang.Integer(1); //$JR_EXPR_ID=4$
                break;
            }
            case 5 : 
            {
                value = new java.lang.Integer(0); //$JR_EXPR_ID=5$
                break;
            }
            case 6 : 
            {
                value = new java.lang.Integer(1); //$JR_EXPR_ID=6$
                break;
            }
            case 7 : 
            {
                value = new java.lang.Integer(0); //$JR_EXPR_ID=7$
                break;
            }
            case 8 : 
            {
                value = ((java.lang.String)field_Cognome.getValue()); //$JR_EXPR_ID=8$
                break;
            }
            case 9 : 
            {
                value = ((java.lang.String)field_Capoluogo.getValue()); //$JR_EXPR_ID=9$
                break;
            }
            case 10 : 
            {
                value = ((java.lang.String)field_Citta.getValue()); //$JR_EXPR_ID=10$
                break;
            }
            case 11 : 
            {
                value = ((java.lang.String)field_Via.getValue()); //$JR_EXPR_ID=11$
                break;
            }
            case 12 : 
            {
                value = ((java.lang.String)field_NumeroCivico.getValue()); //$JR_EXPR_ID=12$
                break;
            }
            case 13 : 
            {
                value = ((java.lang.String)field_CodiceFiscale.getValue()); //$JR_EXPR_ID=13$
                break;
            }
            case 14 : 
            {
                value = ((java.lang.String)field_Nome.getValue()); //$JR_EXPR_ID=14$
                break;
            }
            case 15 : 
            {
                value = ((java.lang.String)field_CodicePostale.getValue()); //$JR_EXPR_ID=15$
                break;
            }
            case 16 : 
            {
                value = ((java.lang.String)field_DataFattura.getValue()); //$JR_EXPR_ID=16$
                break;
            }
            case 17 : 
            {
                value = ((java.lang.String)parameter_NumeroFattura.getValue()); //$JR_EXPR_ID=17$
                break;
            }
            case 18 : 
            {
                value = ((java.lang.String)field_Imponibile.getValue()); //$JR_EXPR_ID=18$
                break;
            }
            case 19 : 
            {
                value = ((java.lang.String)field_Empap.getValue()); //$JR_EXPR_ID=19$
                break;
            }
            case 20 : 
            {
                value = ((java.lang.String)field_Trattamento.getValue()); //$JR_EXPR_ID=20$
                break;
            }
            case 21 : 
            {
                value = ((java.lang.String)field_Trattamento2.getValue()); //$JR_EXPR_ID=21$
                break;
            }
            case 22 : 
            {
                value = ((java.lang.String)field_Trattamento3.getValue()); //$JR_EXPR_ID=22$
                break;
            }
            case 23 : 
            {
                value = ((java.lang.String)field_Bollo.getValue()); //$JR_EXPR_ID=23$
                break;
            }
            case 24 : 
            {
                value = ((java.lang.String)field_TotaleFattura.getValue()); //$JR_EXPR_ID=24$
                break;
            }
           default :
           {
           }
        }
        
        return value;
    }


}
