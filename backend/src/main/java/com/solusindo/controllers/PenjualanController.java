package com.solusindo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solusindo.models.entity.Penjualan;
import com.solusindo.services.PenjualanService;

@RestController
@RequestMapping("/api/penjualan")
public class PenjualanController {
  @Autowired
  private PenjualanService penjualanService;

  @CrossOrigin
  @PostMapping
  public Penjualan create(@RequestBody Penjualan penjualan) {
    return penjualanService.save(penjualan);
  }

  @CrossOrigin
  @DeleteMapping("/{id}")
  public void removeOne(@PathVariable("id") Long id) {
    penjualanService.removeOne(id);
  }

  @CrossOrigin
  @GetMapping
  public Iterable<Penjualan> findAll() {
    return penjualanService.findAll();
  }

  @CrossOrigin
  @GetMapping("/{id}")
  public Penjualan findOne(@PathVariable("id") Long id) {
    return penjualanService.findOne(id);
  }
}
