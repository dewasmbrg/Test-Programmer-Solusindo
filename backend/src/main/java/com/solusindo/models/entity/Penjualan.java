package com.solusindo.models.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "penjualan")
@Getter
@Setter
@Builder
@NoArgsConstructor
public class Penjualan implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long no_faktur;

  @Column(nullable = false)
  @Temporal(TemporalType.DATE)
  private Date tgl_faktur;

  @Column(nullable = false)
  private String nama_konsumen;

  @Column(nullable = false)
  private int jumlah;

  @Column(nullable = false)
  private double harga_satuan;

  @Column(nullable = false)
  private double harga_total;

  @ManyToOne
  @JoinColumn(name = "kode_barang")
  private Barang kode_barang;

  @PrePersist
  private void prePersist() {
    tgl_faktur = new Date();
  }

  public Penjualan(long no_faktur, Date tgl_faktur, String nama_konsumen, int jumlah, double harga_satuan,
      double harga_total, Barang kode_barang) {
    this.no_faktur = no_faktur;
    this.tgl_faktur = tgl_faktur;
    this.nama_konsumen = nama_konsumen;
    this.jumlah = jumlah;
    this.harga_satuan = harga_satuan;
    this.harga_total = harga_total;
    this.kode_barang = kode_barang;
  }

  
}
