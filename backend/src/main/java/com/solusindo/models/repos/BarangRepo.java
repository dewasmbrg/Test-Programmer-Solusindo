package com.solusindo.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.solusindo.models.entity.Barang;

public interface BarangRepo extends CrudRepository<Barang, Long> {
}
