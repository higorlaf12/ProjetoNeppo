/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senhasguarda;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author Higor Lucas
 */
public class Armazenamento {
    
    private String nome;

    public static final String PROP_NOME = "nome";

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        propertyChangeSupport.firePropertyChange(PROP_NOME, oldNome, nome);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    private String Id;

    public static final String PROP_ID = "Id";

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        String oldId = this.Id;
        this.Id = Id;
        propertyChangeSupport.firePropertyChange(PROP_ID, oldId, Id);
    }

    private String Senhas;

    public static final String PROP_SENHAS = "Senhas";

    public String getSenhas() {
        return Senhas;
    }

    public void setSenhas(String Senhas) {
        String oldSenhas = this.Senhas;
        this.Senhas = Senhas;
        propertyChangeSupport.firePropertyChange(PROP_SENHAS, oldSenhas, Senhas);
    }
    

}
