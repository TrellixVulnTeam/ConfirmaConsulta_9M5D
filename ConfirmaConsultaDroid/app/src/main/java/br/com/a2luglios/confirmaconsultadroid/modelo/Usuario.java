package br.com.a2luglios.confirmaconsultadroid.modelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.a2luglios.confirmaconsultadroid.firebase.FirebaseRTDBModel;
import br.com.a2luglios.confirmaconsultadroid.firebase.FirebaseRTDBToken;

/**
 * Created by ettoreluglio on 19/06/17.
 */

public class Usuario implements FirebaseRTDBModel, FirebaseRTDBToken {

    private Long id;
    private String hash;
    private String nome;
    private String lembrete;
    private boolean ehMedico;
    private String hashMedico;
    private long nascimento;
    private String token;
    private String cpf;
    private String rg;
    private Map<String, Object> contato = new HashMap<>();
    private Map<String, Object> endereco = new HashMap<>();
    private List<String> especialidades;
    private List<String> planos;
    private String CRM;
    private List<String> consultorios;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getHash() {
        return hash;
    }

    @Override
    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLembrete() {
        return lembrete;
    }

    public void setLembrete(String lembrete) {
        this.lembrete = lembrete;
    }

    public boolean isEhMedico() {
        return ehMedico;
    }

    public void setEhMedico(boolean ehMedico) {
        this.ehMedico = ehMedico;
    }

    public String getHashMedico() {
        return hashMedico;
    }

    public void setHashMedico(String hashMedico) {
        this.hashMedico = hashMedico;
    }

    public long getNascimento() {
        return nascimento;
    }

    public void setNascimento(long nascimento) {
        this.nascimento = nascimento;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Map<String, Object> getContato() {
        return contato;
    }

    public void setContato(Map<String, Object> contato) {
        this.contato = contato;
    }

    public Map<String, Object> getEndereco() {
        return endereco;
    }

    public void setEndereco(Map<String, Object> endereco) {
        this.endereco = endereco;
    }

    public List<String> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<String> especialidades) {
        this.especialidades = especialidades;
    }

    public List<String> getPlanos() {
        return planos;
    }

    public void setPlanos(List<String> planos) {
        this.planos = planos;
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public List<String> getConsultorios() {
        return consultorios;
    }

    public void setConsultorios(List<String> consultorios) {
        this.consultorios = consultorios;
    }
}
