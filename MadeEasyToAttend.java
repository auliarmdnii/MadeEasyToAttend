import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class MadeEasyToAttend {
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Identifikasi Pengguna
    System.out.println("===== MadeEasyToAttend ======");
    System.out.print("Masukkan jenis pengguna (karyawan/pengunjung): ");
    String userType = scanner.nextLine();

    if (userType.equalsIgnoreCase("karyawan")) {
        // Proses Login untuk Karyawan
        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        if (authenticateUser(username, password)) {
            // Menu Utama untuk Karyawan
            System.out.println("1. Penginputan Timesheet");
            System.out.println("2. Pengajuan Reimbursement");
            System.out.print("Pilih menu (1/2): ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                // Penginputan Timesheet
                System.out.print("Masukkan jumlah jam kerja: ");
                int hoursWorked = scanner.nextInt();
                saveTimesheetData(username, hoursWorked);
            } else if (choice == 2) {
                // Pengajuan Reimbursement
                System.out.println("Jenis kegiatan yang dapat diajukan untuk reimbursement:");
                System.out.println("1. Kegiatan Pelatihan");
                System.out.println("2. Kegiatan Sosial");
                System.out.println("3. Kegiatan Lainnya");
                System.out.print("Pilih jenis kegiatan (1/2/3): ");
                int activityType = scanner.nextInt();
                // Implementasi validasi reimbursement
                validateReimbursement(activityType);
                // Implementasi pembuatan laporan reimbursement
                System.out.print("Apakah Anda ingin membuat laporan reimbursement? (y/n): ");
                String createReport = scanner.next();
                if (createReport.equalsIgnoreCase("y")) {
                    // Pengguna memasukkan data untuk laporan reimbursement
                    scanner.nextLine();
                    System.out.print("Masukkan tanggal (dd/mm/yyyy): ");
                    String date = scanner.nextLine();
                    System.out.print("Masukkan total biaya: ");
                    String cost = scanner.nextLine();
                    System.out.print("Masukkan deskripsi: ");
                    String description = scanner.nextLine();
                    // Implementasi pembuatan laporan reimbursement
                    createReimbursementReport(date, cost, description, username);
                } else if (createReport.equalsIgnoreCase("n")) {
                    System.out.println("Laporan reimbursement tidak dibuat.");
                } else {
                    System.out.println("Pilihan tidak valid.");
                }
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        } else {
            System.out.println("Username atau password salah. Akses ditolak.");
        }
    } else if (userType.equalsIgnoreCase("pengunjung")) {
        // Pengunjung memasukkan nama
        System.out.print("Masukkan nama: ");
        String visitorName = scanner.nextLine();
        // Pengunjung langsung memasukkan data untuk pencatatan
        System.out.print("Masukkan data untuk pencatatan: ");
        String visitorData = scanner.nextLine();
        recordVisitorData(visitorName, visitorData);
    } else {
        System.out.println("Jenis pengguna tidak valid.");
    }

    scanner.close();
}

    // Metode untuk mengautentikasi pengguna (contoh sederhana, perlu diperluas)
    private static boolean authenticateUser(String username, String password) {
        // Implementasi autentikasi sebenarnya
        return true;
    }

    // Metode untuk menyimpan data timesheet karyawan
    private static void saveTimesheetData(String username, int hoursWorked) {
        // Implementasi penyimpanan data timesheet
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("timesheet.txt", true))) {
            writer.write("Username: " + username + ", Jam Kerja: " + hoursWorked + " jam \n");
            System.out.println("Data timesheet berhasil disimpan.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Metode untuk melakukan validasi reimbursement
    private static void validateReimbursement(Integer activityType) {
        // Implementasi validasi reimbursement dengan Lambda Expression
        Runnable validate = () -> {
            if (activityType == 1 || activityType == 2 || activityType == 3) {
                System.out.println("Kegiatan dapat diajukan untuk reimbursement.");
            } else {
                System.out.println("Jenis kegiatan tidak valid.");
            }
        };

        validate.run();
    }

    // Metode untuk membuat laporan reimbursement
    private static void createReimbursementReport(String date, String cost, String description, String username) {
        // Implementasi pembuatan laporan reimbursement
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("reimbursement_report.txt", true))) {
            writer.write("Tanggal: " + date + ", Biaya: " + cost + ", Deskripsi: " + description + ", Username: "
                    + username + "\n");
            System.out.println("Laporan reimbursement berhasil dibuat.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Metode untuk mencatat data pengunjung
    private static void recordVisitorData(String visitorName, String visitorData) {
        // Implementasi pencatatan data pengunjung
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("visitor_log.txt", true))) {
            writer.write("Nama: " + visitorName + ", Data: " + visitorData + "\n");
            System.out.println("Data pengunjung berhasil dicatat.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
