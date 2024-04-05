package bean.estudante;

import jakarta.el.LambdaExpression;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import model.estudante.Estudante;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
@ViewScoped
public class EstudanteRegistrarBean implements Serializable {
    private Estudante estudante = new Estudante();
    private List<String> list = Arrays.asList("Matematica", "Quimica", "Fisica", "Boiologia");
    private Map<Integer, String> map = new HashMap<>();
    private boolean mostrarNotas;

    {
        map.put(1, "Klaus Poppe");
        map.put(2, "Johan");
        map.put(3, "Lunge");
        map.put(4, "Raunheim");
        map.put(5, "Russeldolf");
    }

    public long usarLambda(LambdaExpression le, long valor) {
        long r = (long) le.invoke(FacesContext.getCurrentInstance().getELContext(), valor);
        System.out.println(r);
        return r;
    }

    private boolean bExibirMensagem;
    public void exibirMensagem() {
        bExibirMensagem = !bExibirMensagem;
    }

    public void exibirNotas() {
        mostrarNotas = true;
    }

    public boolean isMostrarNotas() {
        return mostrarNotas;
    }

    public void setMostrarNotas(boolean mostrarNotas) {
        this.mostrarNotas = mostrarNotas;
    }

    public String index2() {
        return "index2?faces-redirect=true";
    }

    public void printar(String msg) {
        System.out.println(msg);
    }

    public Map<Integer, String> getMap() {
        return map;
    }

    public void setMap(Map<Integer, String> map) {
        this.map = map;
    }

    public List<String> getList() {
        return list;
    }

    public boolean isbExibirMensagem() {
        return bExibirMensagem;
    }

    public void setbExibirMensagem(boolean bExibirMensagem) {
        this.bExibirMensagem = bExibirMensagem;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }
}
