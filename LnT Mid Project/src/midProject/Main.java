package midProject;

import java.util.*;

public class Main {
	static Scanner scan = new Scanner(System.in);
	static String tempId, tempNama, tempGender, tempJabatan;
	static int tempGaji=0;
	static Vector<String> vId = new Vector<String>();
	static Vector<String> vNama = new Vector<String>();
	static Vector<String> vGender = new Vector<String>();
	static Vector<String> vJabatan = new Vector<String>();
	static Vector<Integer> vGaji = new Vector<Integer>();
	static int choose = 0;
	static int index = 0;



	static void randomId() {
		Random rand = new Random();
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String xx = "";
		String yyy = "";

		for (int i = 0; i < 2; i++) {
			xx += letters.charAt(rand.nextInt(26));
		}
		for (int i = 0; i < 4; i++) {
			yyy += rand.nextInt(9);
		}
		String tID =  xx +"-"+ yyy;
		//		System.out.println(tID);
		vId.add(tID);

	}
	static void input() {
		randomId();
		do {
			System.out.println("Masukan nama karyawan [Minimal 3 huruf]: ");
			tempNama = scan.nextLine();
		} while (tempNama.length() < 3);
		vNama.add(tempNama);

		do {
			System.out.println("Masukan jenis kelamin [Laki-laki / Perempuan](Case sensitive): ");
			tempGender = scan.nextLine();
		} while (! tempGender.equals("Laki-laki") && ! tempGender.equals("Perempuan"));
		vGender.add(tempGender);

		do {
			System.out.println("Masukan Jabatan [Manager / Supervisor / Admin](Case sensitive): ");
			tempJabatan= scan.nextLine();
		} while (! tempJabatan.equals("Manager") && ! tempJabatan.equals("Supervisor") && ! tempJabatan.equals("Admin"));
		vJabatan.add(tempJabatan);

		if (tempJabatan.equals("Manager")) {
			tempGaji = 8000000;
		} else if (tempJabatan.equals("Supervisor")) {
			tempGaji = 6000000;
		} else if (tempJabatan.equals("Admin")) {
			tempGaji = 4000000;
		}
		vGaji.add(tempGaji);
		System.out.println("ENTER to return");
		scan.nextLine();
		sorting();
	}
	static void view() {
		if (vNama.isEmpty()) {
			System.out.println("Tidak ada data Karyawan");
		} else {
			for (int i=0;i<vNama.size();i++) {
				System.out.println(i+1);
				System.out.println("Kode Karyawan : "+vId.get(i));
				System.out.println("Nama Karyawan : "+vNama.get(i));
				System.out.println("Jenis Kelamin : "+vGender.get(i));
				System.out.println("Jabatan : "+vJabatan.get(i));
				System.out.println("Gaji Karyawan : Rp"+vGaji.get(i));
				System.out.println("----------------------------------");
			}
		}
	}
	static void update() {
		if (vId.isEmpty()) {

		}else {
			System.out.println("Input nomor urutan karyawan yang ingin di update: ");
			index = scan.nextInt();scan.nextLine();

			if (index == 0) {
				System.out.println(" ");

			} else {
				String updatedId = vId.get(index-1);
				randomId();
				do {
					System.out.print("Masukan nama karyawan [Minimal 3 huruf]: ");
					tempNama = scan.nextLine();
				} while (tempNama.length() < 3);
				vNama.set(index-1, tempNama);

				do {
					System.out.println("Masukan jenis kelamin [Laki-laki / Perempuan](Case sensitive): ");
					tempGender = scan.nextLine();
				} while (! tempGender.equals("Laki-laki") && ! tempGender.equals("Perempuan"));
				vGender.set(index-1, tempGender);

				do {
					System.out.println("Masukan Jabatan [Manager / Supervisor / Admin](Case sensitive): ");
					tempJabatan= scan.nextLine();
				} while (! tempJabatan.equals("Manager") && ! tempJabatan.equals("Supervisor") && ! tempJabatan.equals("Admin"));
				vJabatan.set(index-1, tempJabatan);

				if (tempJabatan.equals("Manager")) {
					tempGaji = 8000000;
				} else if (tempJabatan.equals("Supervisor")) {
					tempGaji = 6000000;
				} else if (tempJabatan.equals("Admin")) {
					tempGaji = 4000000;
				}
				vGaji.set(index-1, tempGaji);
				System.out.println("Berhasi mengupdate karyawan dengan Id "+ updatedId);
				System.out.println("ENTER to return");
				scan.nextLine();
			}
		}

	}
	static void delete() {
		if (vNama.isEmpty()) {

		}else {
			do {
				System.out.println("Input nomor urutan karyawan yang ingin di hapus: ");
				index=scan.nextInt();scan.nextLine();
			} while (index > vNama.size()+1);
			String deletedId = vId.get(index-1);
			vId.remove(index-1);
			vNama.remove(index-1);
			vGender.remove(index-1);
			vJabatan.remove(index-1);
			vGaji.remove(index-1);
			System.out.println("Karyawan dengan kode "+deletedId+" berhasil di hapus");
			System.out.println("ENTER to return");
			scan.nextLine();
		}
	}
	static void sorting() {
		String temp1, temp2, temp3, temp4;
		int temp5 = 0;
		for (int i = 0; i < vNama.size()-1; i++) {
			for (int j = 0; j < vNama.size()-i-1; j++) {
				if (vNama.get(j).compareTo(vNama.get(j+1)) > 0){
					temp1 = vId.get(j);
					vId.set(j, vId.get(j+1));
					vId.set(j+1, temp1);
					temp2 = vNama.get(j);
					vNama.set(j, vNama.get(j+1));
					vNama.set(j+1, temp2);
					temp3 = vGender.get(j);
					vGender.set(j, vGender.get(j+1));
					vGender.set(j+1, temp3);
					temp4 = vJabatan.get(j);
					vJabatan.set(j, vJabatan.get(j+1));
					vJabatan.set(j+1, temp4);
					temp5 = vGaji.get(j);
					vGaji.set(j, vGaji.get(j+1));
					vGaji.set(j+1, temp5);
				}
			}
		}



	}
	public Main() {
		do {
			System.out.println("--------------------------");
			System.out.println("Data Karyawan PT Meksiko");
			System.out.println("--------------------------");
			System.out.println("1.	Insert data karyawan");
			System.out.println("2.	View data karyawan");
			System.out.println("3.	Update data karyawan");
			System.out.println("4.	Delete data karyawan");
			System.out.println("5.	Exit");
			System.out.print(">>>");

			choose = scan.nextInt();

			switch (choose) {
			case 1:

				input();
				sorting();

				break;
			case 2:
				view();
				System.out.println("ENTER to return");
				scan.nextLine();scan.nextLine();

				break;
			case 3:
				view();
				update();
				if (index == 0) {
					break;
				}else {
					sorting();
				}


				break;
			case 4:
				view();
				delete();
				sorting();

				break;
			case 5:
				System.out.println("Have a good day~");
				break;

			default:
				System.out.println("Tolong masukan nomor di Menu");
				break;
			}

		}while (choose != 5);
	}


	public static void main(String[] args) {
		new Main();

	}

}
