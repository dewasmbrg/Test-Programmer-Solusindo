<template>
  <div class="hello">
    <h1>Barang List</h1>
    <form @submit.prevent="addBarang">
      <input
        type="text"
        v-model="newBarang.nama_barang"
        placeholder="Nama Barang"
        required
      />
      <input
        type="text"
        v-model="newBarang.satuan"
        placeholder="Satuan"
        required
      />
      <input
        type="text"
        v-model="newBarang.kategori"
        placeholder="Kategori"
        required
      />
      <input
        type="number"
        v-model="newBarang.harga_jual"
        placeholder="Harga Jual"
        required
      />
      <input
        type="number"
        v-model="newBarang.harga_beli"
        placeholder="Harga Beli"
        required
      />
      <button type="submit">Add Barang</button>
    </form>

    <table class="table-barang">
      <thead>
        <tr>
          <th>No</th>
          <th>Nama Barang</th>
          <th>Satuan</th>
          <th>Kategori</th>
          <th>Harga Jual</th>
          <th>Harga Beli</th>
          <th>Actions</th>
        </tr>
      </thead>

      <tbody>
        <tr v-for="(barang, index) in barangs" :key="barang.kode_barang">
          <td>{{ index + 1 }}</td>
          <td>{{ barang.nama_barang }}</td>
          <td>{{ barang.satuan }}</td>
          <td>{{ barang.kategori }}</td>
          <td>{{ barang.harga_jual }}</td>
          <td>{{ barang.harga_beli }}</td>
          <td>
            <!-- Edit button -->
            <button @click="editBarang(barang)">Edit</button>
            <!-- Delete button -->
            <button @click="deleteBarang(barang.kode_barang)">Delete</button>
          </td>
        </tr>
      </tbody>
    </table>

    <h1>Penjualan List</h1>
    <form @submit.prevent="addPenjualan">
      <input
        type="text"
        v-model="newPenjualan.nama_konsumen"
        placeholder="Nama Konsumen"
        required
      />
      <input
        type="number"
        v-model="newPenjualan.jumlah"
        placeholder="Jumlah"
        required
      />
      <input
        type="number"
        v-model="newPenjualan.harga_satuan"
        placeholder="Harga Satuan"
        required
      />
      <input
        type="number"
        v-model="newPenjualan.harga_total"
        placeholder="Harga Total"
        required
      />
      <input
        type="number"
        v-model="newPenjualan.kode_barang"
        placeholder="Kode Barang"
        required
      />
      <button type="submit">Add Penjualan</button>
    </form>

    <table class="table-penjualan">
      <thead>
        <tr>
          <th>No</th>
          <th>Nama Konsumen</th>
          <th>Jumlah</th>
          <th>Harga Satuan</th>
          <th>Harga Total</th>
          <th>Actions</th>
        </tr>
      </thead>

      <tbody>
        <tr v-for="(penjualan, index) in penjualans" :key="penjualan.id">
          <td>{{ index + 1 }}</td>
          <td>{{ penjualan.nama_konsumen }}</td>
          <td>{{ penjualan.jumlah }}</td>
          <td>{{ penjualan.harga_satuan }}</td>
          <td>{{ penjualan.harga_total }}</td>
          <td>
            <button @click="deletePenjualan(penjualan.id)">Delete</button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  data() {
    return {
      barangs: [],
      penjualans: [],
      newBarang: {
        nama_barang: "",
        satuan: "",
        kategori: "",
        harga_jual: 0,
        harga_beli: 0,
      },
      newPenjualan: {
        nama_konsumen: "",
        jumlah: 0,
        harga_satuan: 0,
        harga_total: 0,
      },
      editingBarang: null,
    };
  },
  mounted() {
    this.fetchBarangs();
    this.fetchPenjualans();
  },
  methods: {
    fetchBarangs() {
      fetch("http://localhost:8081/api/barang")
        .then((response) => response.json())
        .then((data) => {
          this.barangs = data;
        })
        .catch((error) => {
          console.error("Error:", error);
        });
    },
    addBarang() {
      fetch("http://localhost:8081/api/barang", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(this.newBarang),
      })
        .then((response) => response.json())
        .then((data) => {
          this.barangs.push(data);
          this.resetBarangForm();
        })
        .catch((error) => {
          console.error("Error:", error);
        });
    },
    editBarang(barang) {
      this.editingBarang = barang;
    },
    updateBarang() {
      fetch("http://localhost:8081/api/barang", {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(this.editingBarang),
      })
        .then((response) => response.json())
        .then((data) => {
          const index = this.barangs.findIndex(
            (barang) => barang.kode_barang === data.kode_barang
          );
          if (index !== -1) {
            this.barangs.splice(index, 1, data);
          }
          this.editingBarang = null;
        })
        .catch((error) => {
          console.error("Error:", error);
        });
    },
    deleteBarang(kode_barang) {
      fetch(`http://localhost:8081/api/barang/${kode_barang}`, {
        method: "DELETE",
      })
        .then(() => {
          this.barangs = this.barangs.filter(
            (barang) => barang.kode_barang !== kode_barang
          );
        })
        .catch((error) => {
          console.error("Error:", error);
        });
    },
    resetBarangForm() {
      this.newBarang = {
        nama_barang: "",
        satuan: "",
        kategori: "",
        harga_jual: 0,
        harga_beli: 0,
      };
    },

    fetchPenjualans() {
      fetch("http://localhost:8081/api/penjualan")
        .then((response) => response.json())
        .then((data) => {
          this.penjualans = data;
        })
        .catch((error) => {
          console.error("Error:", error);
        });
    },
    addPenjualan() {
      fetch("http://localhost:8081/api/penjualan", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(this.newPenjualan),
      })
        .then((response) => response.json())
        .then((data) => {
          this.penjualans.push(data);
          this.resetPenjualanForm();
        })
        .catch((error) => {
          console.error("Error:", error);
        });
    },
    deletePenjualan(id) {
      fetch(`http://localhost:8081/api/penjualan/${id}`, {
        method: "DELETE",
      })
        .then(() => {
          this.penjualans = this.penjualans.filter(
            (penjualan) => penjualan.id !== id
          );
        })
        .catch((error) => {
          console.error("Error:", error);
        });
    },
    resetPenjualanForm() {
      this.newPenjualan = {
        nama_konsumen: "",
        jumlah: 0,
        harga_satuan: 0,
        harga_total: 0,
      };
    },
  },
};
</script>

<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}

.table-barang,
.table-penjualan {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin-top: 5%;
}

td,
th {
  /* border: 1px solid black; */
  padding: 5px;
}

td {
  padding-left: 9px;
  padding-right: 9px;
}
</style>
