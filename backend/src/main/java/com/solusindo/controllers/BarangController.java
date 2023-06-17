package com.solusindo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solusindo.models.entity.Barang;
import com.solusindo.services.BarangService;

@RestController
@RequestMapping("/api/barang")
public class BarangController {
  @Autowired
  private BarangService barangService;

  @CrossOrigin
  @PostMapping
  public Barang create(@RequestBody Barang barang) {
    return barangService.save(barang);
  }

  @CrossOrigin
  @DeleteMapping("/{id}")
  public void removeOne(@PathVariable("id") Long id) {
    barangService.removeOne(id);
  }

  @CrossOrigin
  @GetMapping
  public Iterable<Barang> findAll() {
    return barangService.findAll();
  }

  @CrossOrigin
  @GetMapping("/{id}")
  public Barang findOne(@PathVariable("id") Long id) {
    return barangService.findOne(id);
  }

  @CrossOrigin
  @PutMapping
  public Barang update(@RequestBody Barang barang) {
    return barangService.save(barang);
  }
}
