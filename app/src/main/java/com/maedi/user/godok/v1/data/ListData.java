package com.maedi.user.godok.v1.data;

import com.maedi.user.godok.v1.R;
import com.maedi.user.godok.v1.model.ListMenu;

public class ListData {

	private static ListMenu tag = new ListMenu();

	public static ListMenu listProfile(){
		ListMenu listdata = new ListMenu();
		listdata.add(new ListMenu("Nama Lengkap", "Nama Lengkap Anda"));
		listdata.add(new ListMenu("Tanggal Lahir", "Tgl/Bln/Thn"));
		listdata.add(new ListMenu("Jenis Kelamin", ""));
		listdata.add(new ListMenu("Provinsi", "Nama Provinsi"));
		listdata.add(new ListMenu("Tinggi", "Tinggi Anda"));
		listdata.add(new ListMenu("Berat Badan", "Berat Badan Anda"));
		listdata.add(new ListMenu("Golongan Darah", "O/A/B/AB"));
		listdata.add(new ListMenu("Email", "Email Anda"));
		listdata.add(new ListMenu("Password", "******"));

		return listdata;
	}

	public static ListMenu listMyQuestion(){
		ListMenu listdata = new ListMenu();
		listdata.add(new ListMenu(R.drawable.iko_cantik1, "GIGI", "Dijawab oleh dr. Jolinda", "1 November 2016", "Percakapan ini telah ditutup"));
		listdata.add(new ListMenu(R.drawable.iko_cantik2, "UMUM", "Dijawab oleh dr. Jolinda", "2 November 2016", ""));
		listdata.add(new ListMenu(R.drawable.iko_cantik3, "UMUM", "Dijawab oleh dr. Jolinda", "3 November 2016", "Percakapan ini telah ditutup"));
		listdata.add(new ListMenu(R.drawable.iko_cantik4, "SPESIALIS", "Dijawab oleh dr. Jolinda", "4 November 2016", "Percakapan ini telah ditutup"));
		listdata.add(new ListMenu(R.drawable.iko_cantik5, "UMUM", "Dijawab oleh dr. Jolinda", "5 November 2016", ""));
		listdata.add(new ListMenu(R.drawable.iko_cantik1, "GIGI", "Dijawab oleh dr. Jolinda", "6 November 2016", "Percakapan ini telah ditutup"));
		listdata.add(new ListMenu(R.drawable.iko_cantik2, "SPESIALIS", "Dijawab oleh dr. Jolinda", "7 November 2016", ""));
		listdata.add(new ListMenu(R.drawable.iko_cantik3, "UMUM", "Dijawab oleh dr. Jolinda", "8 November 2016", "Percakapan ini telah ditutup"));
		listdata.add(new ListMenu(R.drawable.iko_cantik4, "BEDAH", "Dijawab oleh dr. Jolinda", "9 November 2016", ""));
		listdata.add(new ListMenu(R.drawable.iko_cantik5, "KULIT", "Dijawab oleh dr. Jolinda", "10 November 2016", "Percakapan ini telah ditutup"));

		return listdata;
	}

	public static ListMenu listPointResult(){
		ListMenu listdata = new ListMenu();
		listdata.add(new ListMenu("Go Dok - Pilih Dokter", "1 November 2016", "20 Poin"));
		listdata.add(new ListMenu("Go Dok - Pilih Dokter", "2 November 2016", "30 Poin"));
		listdata.add(new ListMenu("Go Dok - Pilih Dokter", "3 November 2016", "40 Poin"));
		listdata.add(new ListMenu("Go Dok - Pilih Dokter", "4 November 2016", "50 Poin"));
		listdata.add(new ListMenu("Go Dok - Pilih Dokter", "5 November 2016", "60 Poin"));
		listdata.add(new ListMenu("Go Dok - Pilih Dokter", "6 November 2016", "70 Poin"));
		listdata.add(new ListMenu("Go Dok - Pilih Dokter", "7 November 2016", "80 Poin"));
		listdata.add(new ListMenu("Go Dok - Pilih Dokter", "8 November 2016", "90 Poin"));
		listdata.add(new ListMenu("Go Dok - Pilih Dokter", "9 November 2016", "25 Poin"));
		listdata.add(new ListMenu("Go Dok - Pilih Dokter", "10 November 2016", "30 Poin"));

		return listdata;
	}

	public static ListMenu listPointUsed() {
		ListMenu listdata = new ListMenu();
		listdata.add(new ListMenu("Log In Harian", "Dapatkan poin dengan log in aplikasi Go Dok setiap harinya", "100 Poin"));
		listdata.add(new ListMenu("Like Facebook Page", "Dapatkan poin dengan like facebook Go Dok", "100 Poin"));
		listdata.add(new ListMenu("Share Artikel", "apatkan poin dengan share artikel Go DOk", "110 Poin"));
		listdata.add(new ListMenu("Menuliskan Review", "apatkan poin dengan review Go Dok melalui aplikasi", "120 Poin"));
		listdata.add(new ListMenu("Log In Harian", "Dapatkan poin dengan log in aplikasi Go Dok setiap harinya", "100 Poin"));
		listdata.add(new ListMenu("Like Facebook Page", "Dapatkan poin dengan like facebook Go Dok", "100 Poin"));
		listdata.add(new ListMenu("Share Artikel", "apatkan poin dengan share artikel Go DOk", "110 Poin"));
		listdata.add(new ListMenu("Menuliskan Review", "apatkan poin dengan review Go Dok melalui aplikasi", "120 Poin"));

		return listdata;
	}

	public static ListMenu listInfoHealthy(){
		ListMenu listdata = new ListMenu();
		listdata.add(new ListMenu(R.drawable.iko_cantik1, "A Insert new headline here", "1 November 2016", "Dipos 11 jam yang lalu"));
		listdata.add(new ListMenu(R.drawable.iko_cantik2, "B Insert new headline here", "2 November 2016", "Dipos 11 jam yang lalu"));
		listdata.add(new ListMenu(R.drawable.iko_cantik3, "C Insert new headline here", "3 November 2016", "Dipos 11 jam yang lalu"));
		listdata.add(new ListMenu(R.drawable.iko_cantik4, "D Insert new headline here", "4 November 2016", "Dipos 11 jam yang lalu"));
		listdata.add(new ListMenu(R.drawable.iko_cantik5, "F Insert new headline here", "5 November 2016", "Dipos 11 jam yang lalu"));
		listdata.add(new ListMenu(R.drawable.iko_cantik1, "G Insert new headline here", "6 November 2016", "Dipos 11 jam yang lalu"));
		listdata.add(new ListMenu(R.drawable.iko_cantik2, "H Insert new headline here", "7 November 2016", "Dipos 11 jam yang lalu"));
		listdata.add(new ListMenu(R.drawable.iko_cantik3, "I Insert new headline here", "8 November 2016", "Dipos 11 jam yang lalu"));
		listdata.add(new ListMenu(R.drawable.iko_cantik4, "J Insert new headline here", "9 November 2016", "Dipos 11 jam yang lalu"));
		listdata.add(new ListMenu(R.drawable.iko_cantik5, "K Insert new headline here", "10 November 2016", "Dipos 11 jam yang lalu"));

		return listdata;
	}

	public static ListMenu listFavorite(){
		ListMenu listdata = new ListMenu();
		listdata.add(new ListMenu(R.drawable.iko_cantik1, "1 November 2016", "Dipos 11 jam yang lalu", "Insert new headline here"));
		listdata.add(new ListMenu(R.drawable.iko_cantik2, "2 November 2016", "Dipos 11 jam yang lalu", "Insert new headline here"));
		listdata.add(new ListMenu(R.drawable.iko_cantik3, "3 November 2016", "Dipos 11 jam yang lalu", "Insert new headline here"));
		listdata.add(new ListMenu(R.drawable.iko_cantik4, "4 November 2016", "Dipos 11 jam yang lalu", "Insert new headline here"));
		listdata.add(new ListMenu(R.drawable.iko_cantik5, "5 November 2016", "Dipos 11 jam yang lalu", "Insert new headline here"));
		listdata.add(new ListMenu(R.drawable.iko_cantik1, "6 November 2016", "Dipos 11 jam yang lalu", "Insert new headline here"));
		listdata.add(new ListMenu(R.drawable.iko_cantik2, "7 November 2016", "Dipos 11 jam yang lalu", "Insert new headline here"));
		listdata.add(new ListMenu(R.drawable.iko_cantik3, "8 November 2016", "Dipos 11 jam yang lalu", "Insert new headline here"));
		listdata.add(new ListMenu(R.drawable.iko_cantik4, "9 November 2016", "Dipos 11 jam yang lalu", "Insert new headline here"));
		listdata.add(new ListMenu(R.drawable.iko_cantik5, "10 November 2016", "Dipos 11 jam yang lalu", "Insert new headline here"));

		return listdata;
	}

	public static ListMenu listArticle(){
		ListMenu listdata = new ListMenu();
		listdata.add(new ListMenu(R.drawable.iko_cantik1, "Info Sehat"));
		listdata.add(new ListMenu(R.drawable.iko_cantik2, "Gaya Hidup"));
		listdata.add(new ListMenu(R.drawable.iko_cantik3, "Keluarga"));
		listdata.add(new ListMenu(R.drawable.iko_cantik4, "Ragam Penyakit"));
		listdata.add(new ListMenu(R.drawable.iko_cantik5, "Info Sehat"));
		listdata.add(new ListMenu(R.drawable.iko_cantik1, "Gaya Hidup"));
		listdata.add(new ListMenu(R.drawable.iko_cantik2, "Keluarga"));
		listdata.add(new ListMenu(R.drawable.iko_cantik3, "Ragam Penyakit"));
		listdata.add(new ListMenu(R.drawable.iko_cantik4, "Info Sehat"));
		listdata.add(new ListMenu(R.drawable.iko_cantik5, "Gaya Hidup"));

		return listdata;
	}

	public static ListMenu listEvent(){
		ListMenu listdata = new ListMenu();
		listdata.add(new ListMenu("A Insert new headline here", "1 November 2016"));
		listdata.add(new ListMenu("B Insert new headline here", "2 November 2016"));
		listdata.add(new ListMenu("C Insert new headline here", "3 November 2016"));
		listdata.add(new ListMenu("D Insert new headline here", "4 November 2016"));
		listdata.add(new ListMenu("F Insert new headline here", "5 November 2016"));
		listdata.add(new ListMenu("G Insert new headline here", "6 November 2016"));
		listdata.add(new ListMenu("H Insert new headline here", "7 November 2016"));
		listdata.add(new ListMenu("I Insert new headline here", "8 November 2016"));
		listdata.add(new ListMenu("J Insert new headline here", "9 November 2016"));
		listdata.add(new ListMenu("K Insert new headline here", "10 November 2016"));

		return listdata;
	}

	public static ListMenu listDoctor(){
		ListMenu listdata = new ListMenu();
		listdata.add(new ListMenu(R.drawable.iko_cantik1, "Dr. Jolinda Johary", "Dokter Umum", "4.5 / 5", "Waktu praktik: selasa jam 10 pagi - 12 siang", "Online"));
		listdata.add(new ListMenu(R.drawable.iko_cantik2, "Dr. Jolinda Johary", "Dokter Umum", "4.5 / 5", "Waktu praktik: selasa jam 10 pagi - 12 siang", "Online"));
		listdata.add(new ListMenu(R.drawable.iko_cantik3, "Dr. Jolinda Johary", "Dokter Umum", "4.5 / 5", "Waktu praktik: selasa jam 10 pagi - 12 siang", "Online"));
		listdata.add(new ListMenu(R.drawable.iko_cantik4, "Dr. Jolinda Johary", "Dokter Umum", "4.5 / 5", "Waktu praktik: selasa jam 10 pagi - 12 siang", "Online"));
		listdata.add(new ListMenu(R.drawable.iko_cantik5, "Dr. Jolinda Johary", "Dokter Umum", "4.5 / 5", "Waktu praktik: selasa jam 10 pagi - 12 siang", "Online"));
		listdata.add(new ListMenu(R.drawable.iko_cantik1, "Dr. Jolinda Johary", "Dokter Umum", "4.5 / 5", "Waktu praktik: selasa jam 10 pagi - 12 siang", "Online"));
		listdata.add(new ListMenu(R.drawable.iko_cantik2, "Dr. Jolinda Johary", "Dokter Umum", "4.5 / 5", "Waktu praktik: selasa jam 10 pagi - 12 siang", "Online"));
		listdata.add(new ListMenu(R.drawable.iko_cantik3, "Dr. Jolinda Johary", "Dokter Umum", "4.5 / 5", "Waktu praktik: selasa jam 10 pagi - 12 siang", "Online"));
		listdata.add(new ListMenu(R.drawable.iko_cantik4, "Dr. Jolinda Johary", "Dokter Umum", "4.5 / 5", "Waktu praktik: selasa jam 10 pagi - 12 siang", "Online"));
		listdata.add(new ListMenu(R.drawable.iko_cantik5, "Dr. Jolinda Johary", "Dokter Umum", "4.5 / 5", "Waktu praktik: selasa jam 10 pagi - 12 siang", "Online"));

		return listdata;
	}

	public static ListMenu listCommentArticle(){
		ListMenu listdata = new ListMenu();
		listdata.add(new ListMenu(R.drawable.iko_cantik1, "Malika", "Laporkan", "1 November 2016", "11.52 am", "Wah artikel nya bagus banget, diperbanyak lagi dong", "10 Suka", "0 Tidak Suka", "Balas"));
		listdata.add(new ListMenu(R.drawable.iko_cantik2, "Udin", "Laporkan", "2 November 2016", "11.52 am", "Wah artikel nya bagus banget, diperbanyak lagi dong", "10 Suka", "0 Tidak Suka", "Balas"));
		listdata.add(new ListMenu(R.drawable.iko_cantik3, "Joko", "Laporkan", "3 November 2016", "11.52 am", "Wah artikel nya bagus banget, diperbanyak lagi dong", "10 Suka", "0 Tidak Suka", "Balas"));
		listdata.add(new ListMenu(R.drawable.iko_cantik4, "Danang", "Laporkan", "4 November 2016", "11.52 am", "Wah artikel nya bagus banget, diperbanyak lagi dong", "10 Suka", "0 Tidak Suka", "Balas"));
		listdata.add(new ListMenu(R.drawable.iko_cantik5, "Malika", "Laporkan", "5 November 2016", "11.52 am", "Wah artikel nya bagus banget, diperbanyak lagi dong", "10 Suka", "0 Tidak Suka", "Balas"));
		listdata.add(new ListMenu(R.drawable.iko_cantik1, "Udin", "Laporkan", "6 November 2016", "11.52 am", "Wah artikel nya bagus banget, diperbanyak lagi dong", "10 Suka", "0 Tidak Suka", "Balas"));
		listdata.add(new ListMenu(R.drawable.iko_cantik2, "Joko", "Laporkan", "7 November 2016", "11.52 am", "Wah artikel nya bagus banget, diperbanyak lagi dong", "10 Suka", "0 Tidak Suka", "Balas"));
		listdata.add(new ListMenu(R.drawable.iko_cantik3, "Danang", "Laporkan", "8 November 2016", "11.52 am", "Wah artikel nya bagus banget, diperbanyak lagi dong", "10 Suka", "0 Tidak Suka", "Balas"));
		listdata.add(new ListMenu(R.drawable.iko_cantik4, "Malika", "Laporkan", "9 November 2016", "11.52 am", "Wah artikel nya bagus banget, diperbanyak lagi dong", "10 Suka", "0 Tidak Suka", "Balas"));
		listdata.add(new ListMenu(R.drawable.iko_cantik5, "Udin", "Laporkan", "10 November 2016", "11.52 am", "Wah artikel nya bagus banget, diperbanyak lagi dong", "10 Suka", "0 Tidak Suka", "Balas"));

		return listdata;
	}

	public static ListMenu listChat(){
		ListMenu listdata = new ListMenu();
		listdata.add(new ListMenu(R.drawable.iko_cantik1, "Jolinda", "Apakah Anda sudah minum obat parasetamol", "15:30 AM", 0));
		listdata.add(new ListMenu(R.drawable.iko_cantik1, "Malika", "Belum sama sekali dok", "15:30 AM", 1));
		listdata.add(new ListMenu(R.drawable.iko_cantik1, "Jolinda", "Apakah Anda sudah minum obat parasetamol", "15:30 AM", 0));
		listdata.add(new ListMenu(R.drawable.iko_cantik1, "Malika", "Belum sama sekali dok", "15:30 AM", 1));
		listdata.add(new ListMenu(R.drawable.iko_cantik1, "Jolinda", "Apakah Anda sudah minum obat parasetamol", "15:30 AM", 0));
		listdata.add(new ListMenu(R.drawable.iko_cantik1, "Malika", "Belum sama sekali dok", "15:30 AM", 1));
		listdata.add(new ListMenu(R.drawable.iko_cantik1, "Jolinda", "Apakah Anda sudah minum obat parasetamol", "15:30 AM", 0));
		listdata.add(new ListMenu(R.drawable.iko_cantik1, "Malika", "Belum sama sekali dok", "15:30 AM", 1));
		listdata.add(new ListMenu(R.drawable.iko_cantik1, "Jolinda", "Apakah Anda sudah minum obat parasetamol", "15:30 AM", 0));
		listdata.add(new ListMenu(R.drawable.iko_cantik1, "Malika", "Belum sama sekali dok", "15:30 AM", 1));

		return listdata;
	}

	public static String[] TabsText(){
		return new String[]{"Beranda", "Artikel dan Video", "Acara"};
	}

	public static String[] TabsPoinText(){
		return new String[]{"Perolehan", "Penggunaan"};
	}

}
