/*-------------------------------------------------------------------------
---------------------------------------------------------------------------
---	Universidade Federal de São Carlos - Campus Sorocaba 		---
---	Bacharelado em Ciência da Computação				---
---	Sorriso de Criança						---
---									---
---		Bruno Pereira						---
---		Celso Araujo Filho					---
---		Cristiano Silva						---
---		Pedro Brito Junior					---
---		Yasmin Beatriz Alves da Silva 				---
---									---
---------------------------------------------------------------------------
---------------------------------------------------------------------------
*/
package models;

import java.sql.Date;


public class ModelPresenca 
{
    private int crianca;
    private Date data_presenca;
    private String status; 

    public int getCrianca() {
        return crianca;
    }

    public void setCrianca(int crianca) {
        this.crianca = crianca;
    }

    public Date getData_presenca() {
        return data_presenca;
    }

    public void setData_presenca(Date data_presenca) {
        this.data_presenca = data_presenca;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
