# 🏃‍♀️ Aplikasi Catat Lari

## 📝 Description
Aplikasi **Catat Lari** adalah aplikasi mobile berbasis Android yang digunakan untuk membantu pengguna mencatat aktivitas olahraga lari.  
Aplikasi ini memungkinkan pengguna untuk menyimpan dan melihat data aktivitas lari yang telah dilakukan.

---

## 🚀 Fitur Utama
Berikut adalah fitur-fitur yang tersedia dalam aplikasi:
- **Autentikasi**  Fitur yang digunakan oleh pengguna untuk membuat akun baru (registrasi) dan masuk ke dalam aplikasi (login) menggunakan email dan password.  
- **Home** Menampilkan informasi utama pengguna seperti nama, total aktivitas lari, dan target jarak harian. Selain itu, pengguna dapat melihat daftar aktivitas lari yang telah dilakukan, serta menambahkan, mengedit, dan menghapus data aktivitas lari.
- **Tambah Data Lari** Fitur untuk mencatat aktivitas lari baru dengan menginput tanggal, jarak tempuh, dan durasi lari.
- **Kelola Data Lari** Pengguna dapat mengedit atau menghapus data aktivitas lari yang sudah tersimpan.
- **Profile** Pengguna dapat melihat dan memperbarui informasi profil akun sesuai kebutuhan.


## ⚙️ Tech Stack
- Kotlin
- Model-View-ViewModel
- XML Layout


## 🧠 Arsitektur
Aplikasi ini menggunakan arsitektur **MVVM (Model-View-ViewModel)**:
- **Model** → `Run.kt`, `User.kt`  
- **View** → `AddRunFragment.kt`, `HomeFragment.kt`,`LoginFragment.kt`, `ProfileFragment.kt`, `RegisterFragment.kt`, `WelcomeFragment.kt`, `AuthActivity.kt`, `MainActivity.kt`, dan `RunAdapter.kt`  
- **ViewModel** → `RunViewModel.kt`  

---

## 👥 Anggota Kelompok

- Nadia Ardiyanti Sutrisno (24082010065)  
- Shelvia Retha Sofiana    (24082010082)  
- Nafiisha Nuurfathina     (24082010090)  
