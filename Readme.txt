Program ini menggunakan 2 framework yaitu Vue JS sebagai Front End dan Springboot sebagai backend.


Cara menjalankan:
- Pastikan Mysql server anda menyala
- Buatlah database dengan nama test_solusindo
- Cocokkan konfigurasi database mysql anda dengan application properties pada springboot di dalam folder backend
- Jalankan backend menggunakan perintah : "mvn spring-boot:run"
(pastikan path terminal anda didalam folder backend)
- Masuk ke folder frontend menggunakan terminal, jika anda belum memiliki node modulesnya, lakukan instalasinya menggunakan perintah "pnpm i" (bukan npm) dikarenakan disini saya menggunakan konfigurasi pnpm.
- Jika semua dependency package sudah terinstall, ketik perintah "pnpm run serve" untuk menjalankan frontendnya
- Lalu akan muncul local url yang bisa anda akses.
- Selamat mencoba

Notes:
- Jika port nya bertabrakan antara frontend dan backend, silahkan ubah port backend nya di application.properties
Disini saya menggunakan 8080 untuk FE dan 8081 untuk BE