package com.solusindo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solusindo.models.entity.Penjualan;
import com.solusindo.models.repos.PenjualanRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PenjualanService {
  @Autowired
  private PenjualanRepo penjualanRepo;

  public Penjualan save(Penjualan penjualan) {
    return penjualanRepo.save(penjualan);
  }

  public Penjualan findOne(Long id) {
    Optional<Penjualan> penjualan = penjualanRepo.findById(id);
    if (!penjualan.isPresent()) {
      return null;
    }
    return penjualanRepo.findById(id).get();
  }

  public Iterable<Penjualan> findAll() {
    return penjualanRepo.findAll();
  }

  public void removeOne(Long id) {
    penjualanRepo.deleteById(id);
  }
}
