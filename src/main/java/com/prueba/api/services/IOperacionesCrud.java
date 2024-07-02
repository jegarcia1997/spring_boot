package com.prueba.api.services;

import com.prueba.api.dtos.ResultadoDTO;

public interface IOperacionesCrud<T> {
    ResultadoDTO listar();

    ResultadoDTO consultar(T entidad);

    ResultadoDTO crear(T entidad);

    ResultadoDTO editar(T entidadExistente, T entidadActualizada);

    ResultadoDTO eliminar(T entidad);
}
