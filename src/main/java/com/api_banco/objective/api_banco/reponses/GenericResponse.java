package com.api_banco.objective.api_banco.reponses;

public class GenericResponse<T> {
    public T Data;
    public String Error;
    public boolean Success = true;
}
