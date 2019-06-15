package osvaldo.unifacear.edu.br.provaandroidosvaldo_marlon.entity;

/**
 * Created by osval on 14/06/2019.
 */

public class Mensagem {

    private String usuario;
    private String mensagem;

    @Override
    public String toString() {
        return "Mensagem{" +
                "usuario='" + usuario + '\'' +
                ", mensagem='" + mensagem + '\'' +
                '}';
    }

    public Mensagem() {
    }

    public Mensagem(String usuario, String mensagem) {
        this.usuario = usuario;
        this.mensagem = mensagem;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
