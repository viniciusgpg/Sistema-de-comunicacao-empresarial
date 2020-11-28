/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import com.google.gson.JsonObject;

public class Mensagens {
    private int id;
    private String email;
    private int id_projeto;
    private String name;
    private String messages;
    private String created_at;

    public Mensagens(int id, int id_projeto ,String name, String messages, String created_at,String email) {
        this.id = id;
        this.id_projeto=id_projeto;
        this.name = name;
        this.messages = messages;
        this.created_at = created_at;
        this.email=email;
    }

    
    
    public Mensagens(int id_projeto ,String name, String messages, String created_at,String email) {
        this.id_projeto=id_projeto;
        this.name = name;
        this.messages = messages;
        this.created_at = created_at;
        this.email=email;
    }
    
    
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
      /**
     * @return the id_projeto
     */
    public int getId_projeto() {
        return id_projeto;
    }

    /**
     * @param id_projeto the id to set
     */
    public void setId_projeto(int id_projeto) {
        this.id_projeto = id_projeto;
    }

    /**
     * @return the name
     */
    public String getNome() {
        return name;
    }

    /**
     * @param name the nome to set
     */
    public void setNome(String name) {
        this.name = name;
    }

    /**
     * @return the messages
     */
    public String getMensagens() {
        return messages;
    }

    /**
     * @param messages the messages to set
     */
    public void setMensagens(String messages) {
        this.messages = messages;
    }

    /**
     * @return the created_at
     */
    public String getCreated_at() {
        return created_at;
    }

    /**
     * @param created_at the criado to set
     */
    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    public JsonObject getJsonObject(){
        JsonObject jo = new JsonObject();
        
        jo.addProperty("id", this.getId());
        jo.addProperty("id_projeto", this.getId_projeto());
        jo.addProperty("name", this.getNome());
        jo.addProperty("messages", this.getMensagens());
        jo.addProperty("created_at", this.getCreated_at());
        jo.addProperty("email", this.getEmail());
        return jo;
    }
    
   
    
}

