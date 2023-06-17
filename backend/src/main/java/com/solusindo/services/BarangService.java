package com.solusindo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solusindo.models.entity.Barang;
import com.solusindo.models.repos.BarangRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BarangService {
  @Autowired
  private BarangRepo barangRepo;

  public Barang save(Barang barang) {
    return barangRepo.save(barang);
  }

  public Barang findOne(Long id) {
    Optional<Barang> barang = barangRepo.findById(id);
    if (!barang.isPresent()) {
      return null;
    }
    return barangRepo.findById(id).get();
  }

  public Iterable<Barang> findAll() {
    return barangRepo.findAll();
  }

  public void removeOne(Long id) {
    barangRepo.deleteById(id);
  }
}
