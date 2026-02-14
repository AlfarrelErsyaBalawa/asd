package TP.TP1;
import java.util.Scanner;

public class BurhanQuest {
    // Banner pembuka
    private static final String BANNER = 
        " ███████████                       █████                                 ██████                                 █████   \r\n" + //
        "░░███░░░░░███                     ░░███                                ███░░░░███                              ░░███    \r\n" + //
        " ░███    ░███ █████ ████ ████████  ░███████    ██████   ████████      ███    ░░███ █████ ████  ██████   █████  ███████  \r\n" + //
        " ░██████████ ░░███ ░███ ░░███░░███ ░███░░███  ░░░░░███ ░░███░░███    ░███     ░███░░███ ░███  ███░░███ ███░░  ░░░███░   \r\n" + //
        " ░███░░░░░███ ░███ ░███  ░███ ░░░  ░███ ░███   ███████  ░███ ░███    ░███   ██░███ ░███ ░███ ░███████ ░░█████   ░███    \r\n" + //
        " ░███    ░███ ░███ ░███  ░███      ░███ ░███  ███░░███  ░███ ░███    ░░███ ░░████  ░███ ░███ ░███░░░   ░░░░███  ░███ ███\r\n" + //
        " ███████████  ░░████████ █████     ████ █████░░████████ ████ █████    ░░░██████░██ ░░████████░░██████  ██████   ░░█████ \r\n" + //
        "░░░░░░░░░░░    ░░░░░░░░ ░░░░░     ░░░░ ░░░░░  ░░░░░░░░ ░░░░ ░░░░░       ░░░░░░ ░░   ░░░░░░░░  ░░░░░░  ░░░░░░     ░░░░░  \r\n" + //
        "                                                                                                                        \r\n" + //
        "                                                                                                                        \r\n" + //
        "                                                                                                                        ";
    private static final String STUDENT_NAME = "Alfarrel Ersya Balawa";
    private static final String STUDENT_ID = "2506656406";


    // Penanda atribut
    // Atribut yang sama
    private static final char NAME_IDENTIFIER = '!';
    private static final char STATUS_IDENTIFIER = '@';
    private static final char EXP_IDENTIFIER = '#';

    // Atribut khusus quest
    private static int questId = 1;
    private static final char REWARD_IDENTIFIER = '$';
    private static final char DESC_IDENTIFIER = '%';
    private static final char DIFFICULTY_IDENTIFIER = '^';

    // Atribut khusus pengembara
    private static int travelerId = 1;
    private static final char LEVEL_IDENTIFIER = '$';

    private static final int MAX_EXP = 1_310_720_000;

    // Scanner untuk input
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println(BANNER);
        System.out.println("Selamat datang di BurhanQuest!");
        System.out.println("Dibuat oleh: " + STUDENT_NAME + " - " + STUDENT_ID);
        System.out.println("Mari kita mulai dengan membuat sejumlah data quest dan pengembara.");

        int questCount=0, travelerCount=0;
        boolean invalidInput = true;

        // While loop yang akan mengulang permintaan input ke user selama input tidak valid
        while (invalidInput) {
            System.out.print("Silakan masukkan banyak quest yang ingin didaftarkan: ");
            String questCountInput = input.nextLine();
            // For loop yang mengecek tiap karakter dalam input string apakah karakter tersebut adalah sebuah angka
            for (int i = 0; i < questCountInput.length(); i++) {
                char ch = questCountInput.charAt(i);
                if (!Character.isDigit(ch)) {
                    System.out.println("Input tidak valid. Harap memasukkan input bilangan bulat nonnegatif.");
                    break;
                }
            }

            if (Integer.parseInt(questCountInput)>0) {
                questCount = Integer.parseInt(questCountInput);
                invalidInput = false;
            }
            System.out.println("Input tidak valid. Harap masukkan bilangan bulat nonnegatif.");
        }
        
        invalidInput = true;

        // While loop yang akan mengulang permintaan input ke user selama input tidak valid
        while (invalidInput) {
            System.out.print("Silakan masukkan banyak pengembara yang ingin didaftarkan: ");
            String travelerCountInput = input.nextLine();
            // For loop yang mengecek tiap karakter dalam input string apakah karakter tersebut adalah sebuah angka
            for (int i = 0; i < travelerCountInput.length(); i++) {
                char ch = travelerCountInput.charAt(i);
                if (!Character.isDigit(ch)) {
                    System.out.println("Input tidak valid. Harap memasukkan input bilangan bulat nonnegatif.");
                    break;
                }
            }

            if (Integer.parseInt(travelerCountInput)>0) {
                travelerCount = Integer.parseInt(travelerCountInput);
                invalidInput = false;
            }
            System.out.println("Input tidak valid. Harap masukkan bilangan bulat nonnegatif.");
        }
        System.out.println();

        String questData = "";
        String travelerData = "";
        System.out.println("Mulai memasukkan data quest.");
        for (int i = 1; i <= questCount; i++) {
            boolean questDataValid = false;
            while (!questDataValid) {
                // Input data quest
                System.out.println("Quest " + i);
                System.out.print("Masukkan nama quest: ");
                String namaQuest = input.nextLine();
                System.out.print("Masukkan deskripsi quest: ");
                String questDescription = input.nextLine();
                System.out.print("Masukkan reward quest (bilangan bulat nonnegatif): ");
                String reward = input.nextLine();
                System.out.print("Masukkan bonus exp quest (bilangan bulat nonnegatif): ");
                String expBonus = input.nextLine();
                System.out.print("Masukkan tingkat kesulitan quest (mudah/menegah/sulit): ");
                String difficulty = input.nextLine();

                // Validasi input data quest
                boolean questNameValid = true;
                for (int c=0;c<namaQuest.length();c++) {
                    char ch = namaQuest.charAt(c);
                    if (!Character.isLetterOrDigit(ch)) {
                        questNameValid = false;
                    }
                }

                boolean questDescValid = true;
                for (int c=0;c<questDescription.length();c++) {
                    char ch = questDescription.charAt(c);
                    if (!Character.isLetterOrDigit(ch)) {
                        questDescValid = false;
                    }
                }

                boolean questRewardValid = true;
                for (int c=0;c<reward.length();c++) {
                    char ch = reward.charAt(c);
                    if (!Character.isLetterOrDigit(ch)) {
                        questRewardValid = false;
                    }
                }
                int intReward = Integer.parseInt(reward);

                boolean questExpBonusValid = true;
                for (int c=0;c<expBonus.length();c++) {
                    char ch = expBonus.charAt(c);
                    if (!Character.isLetterOrDigit(ch)) {
                        questExpBonusValid = false;
                    }
                }
                int intExpBonus = Integer.parseInt(expBonus);

                boolean questDifficultyValid = false;
                if (difficulty.equalsIgnoreCase("mudah"))
                    questDifficultyValid = true;
                else if (difficulty.equalsIgnoreCase("menengah"))
                    questDifficultyValid = true;
                else if (difficulty.equalsIgnoreCase("sulit"))
                    questDifficultyValid = true;
                
                // // DEBUGGING
                // System.out.println(questNameValid);
                // System.out.println(questDescValid);
                // System.out.println(questRewardValid);
                // System.out.println(questExpBonusValid);
                // System.out.println(questDifficultyValid);

                if (questNameValid && questDescValid && questRewardValid && questExpBonusValid && questDifficultyValid){
                    questDataValid = true;
                    System.out.println("Quest berhasil ditambahkan");
                }
                else{
                    System.out.println("Input tidak vaild, harap masukkan data dengan benar.");
                }
            }
        }

        System.out.println("Mulai memasukkan data pengembara.");
        // TODO: Input data pengembara sebanyak pengembara yang diminta
        for (int i = 0; i < travelerCount; i++) {
            
        }
        System.out.println("Data berhasil dimasukkan.");
        System.out.println();

        boolean running = true;
        // TODO: Loop menu utama
        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Lihat daftar quest");
            System.out.println("2. Lihat daftar pengembara");
            System.out.println("3. Tambah quest");
            System.out.println("4. Tambah pengembara");
            System.out.println("5. Menjalankan quest");
            System.out.println("6. Menyelesaikan quest");
            System.out.println("7. Filter daftar quest");
            System.out.println("8. Filter daftar pengembara");
            System.out.println("9.Tampilkan daftar quest terurut");
            System.out.println("10.Tampilkan daftar pengembara terurut");
            System.out.println("11. Keluar");
            System.out.print("Masukkan pilihan: ");
            String choice = input.nextLine().trim();

            switch (choice) {
                case "1":
                    // TODO: Tampilkan daftar quest
                    System.out.println("Belum diimplementasikan");
                    break;
                case "2":
                    // TODO: Tampilkan daftar pengembara
                    System.out.println("Belum diimplementasikan");
                    break;
                case "3":
                    // TODO: Tambah quest
                    System.out.println("Belum diimplementasikan");
                    break;
                case "4":
                    // TODO: Tambah pengembara
                    System.out.println("Belum diimplementasikan");
                    break;
                case "5":
                    // TODO: Menjalankan quest
                    System.out.println("Belum diimplementasikan");
                    break;
                case "6":
                    // TODO: Menyelesaikan quest
                    System.out.println("Belum diimplementasikan");
                    break;
                case "7":
                    // TODO: Filter daftar quest
                    System.out.println("Belum diimplementasikan");
                    break;
                case "8":
                    // TODO: Filter daftar pengembara
                    System.out.println("Belum diimplementasikan");
                    break;
                case "9":
                    // TODO: Tampilkan daftar quest terurut
                    System.out.println("Belum diimplementasikan");
                    break;
                case "10":
                    // TODO: Tampilkan daftar pengembara terurut
                    System.out.println("Belum diimplementasikan");
                    break;
                case "11":
                    // TODO: Keluar
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        }
    }
}
