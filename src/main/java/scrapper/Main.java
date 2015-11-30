package scrapper;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by rsl_prod_005 on 11/3/15.
 */
public class Main {
    public static void main(String[] args){
        String url
                = "\n" +
                "http://www.amazon.com/gp/product/B00WL6QGIG/ref=s9_ri_bw_g351_i1?pf_rd_m=ATVPDKIKX0DER&pf_rd_s=merchandised-search-3&pf_rd_r=0P8KWBVSM2S7HGMBYTT7&pf_rd_t=101&pf_rd_p=1720194962&pf_rd_i=154606011%5C";
        HtmlUnitImpl htmlUnit = new HtmlUnitImpl(url);
        String dataValue = htmlUnit.getDataById("myExperience-1");

        if(StringUtils.isNotBlank(dataValue)) {
            System.out.println("Data value : " + dataValue);
        } else {
            System.out.println("Nothing found!");
        }
    }
}
