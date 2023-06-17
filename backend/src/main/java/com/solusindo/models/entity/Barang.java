package com.solusindo.models.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "barang")
@Getter
@Setter
public class Barang implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long kode_barang;

  @Column(nullable = false)
  private String nama_barang;

  @Column(nullable = false)
  private double harga_jual;

  @Column(nullable = false)
  private double harga_beli;

  @Column(nullable = false)
  private String satuan;

  @Column(nullable = false)
  private String kategori;

  @OneToMany(mappedBy = "kode_barang", cascade = CascadeType.ALL)
  private List<Penjualan> penjualans;

  public Barang() {
  }

  public Barang(long kode_barang, String nama_barang, double harga_jual, double harga_beli, String satuan,
      String kategori, List<Penjualan> penjualans) {
    this.kode_barang = kode_barang;
    this.nama_barang = nama_barang;
    this.harga_jual = harga_jual;
    this.harga_beli = harga_beli;
    this.satuan = satuan;
    this.kategori = kategori;
    this.penjualans = penjualans;
  }
}
