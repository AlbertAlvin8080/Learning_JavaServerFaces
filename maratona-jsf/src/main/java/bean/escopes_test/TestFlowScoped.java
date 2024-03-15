package bean.escopes_test;

import jakarta.faces.flow.FlowScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@FlowScoped(value = "registration")
public class TestFlowScoped implements Serializable {
    private String nome;
    private String sobrenome;
    private String endereco;

    public void saveData() {
        System.out.println("Salvando...");
        System.out.println(nome);
        System.out.println(sobrenome);
        System.out.println(endereco);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
