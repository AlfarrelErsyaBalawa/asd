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
                    continue;
                }
            }

            if (Integer.parseInt(questCountInput)>0) {
                questCount = Integer.parseInt(questCountInput);
                invalidInput = false;
                break;
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
                    continue;
                }
            }
            
            if (Integer.parseInt(travelerCountInput)>0) {
                travelerCount = Integer.parseInt(travelerCountInput);
                invalidInput = false;
                break;
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
                System.out.print("Masukkan tingkat kesulitan quest (mudah/menengah/sulit): ");
                String difficulty = input.nextLine();

                // Validasi input data quest
                boolean questNameValid = true;
                for (int c=0;c<namaQuest.length();c++) {
                    char ch = namaQuest.charAt(c);
                    // mengecek apakah karakter adalah huruf atau digit atau spasi
                    if (!(Character.isLetterOrDigit(ch) || ch == " ".charAt(0))) {
                        questNameValid = false;
                    }
                }

                boolean questDescValid = true;
                for (int c=0;c<questDescription.length();c++) {
                    char ch = questDescription.charAt(c);
                    if (!(Character.isLetterOrDigit(ch) || ch == " ".charAt(0))) {
                        questDescValid = false;
                    }
                }

                boolean questRewardValid = true;
                int intReward = Integer.parseInt(reward);
                for (int c=0;c<reward.length();c++) {
                    char ch = reward.charAt(c);
                    if (!(Character.isDigit(ch) || intReward >= 0)) {
                        questRewardValid = false;
                    }
                }

                boolean questExpBonusValid = true;
                int intExpBonus = Integer.parseInt(expBonus);
                for (int c=0;c<expBonus.length();c++) {
                    char ch = expBonus.charAt(c);
                    if (!(Character.isDigit(ch) || intExpBonus >= 0)) {
                        questExpBonusValid = false;
                    }
                }

                boolean questDifficultyValid = false;
                if (difficulty.equalsIgnoreCase("mudah"))
                    questDifficultyValid = true;
                else if (difficulty.equalsIgnoreCase("menengah"))
                    questDifficultyValid = true;
                else if (difficulty.equalsIgnoreCase("sulit"))
                    questDifficultyValid = true;

                if (questNameValid && questDescValid && questRewardValid && questExpBonusValid && questDifficultyValid){
                    questDataValid = true;
                    questData = questData + "Q"+i +"|"+ namaQuest +"|"+ questDescription +"|"+ reward +"|"+ expBonus +"|"+ difficulty +"|"+ "tersedia\ud83d\udfe2" + "$";
                    System.out.println("Quest berhasil ditambahkan");
                }
                else{
                    System.out.println("Input tidak vaild. Harap masukkan data dengan benar.");
                }
            }
        }

        System.out.println("Mulai memasukkan data pengembara.");
        for (int i = 1; i <= travelerCount; i++) {
            boolean pengembaraDataValid = false;
            while (!pengembaraDataValid) {
                // Input data pengembara
                System.out.println("Pengembara " + i);
                System.out.print("Masukkan nama pengembara: ");
                String pengembaraNama = input.nextLine();
                System.out.print("Masukkan level pengembara berupa bilangan bulat [1,20]: ");
                String pengembaraLevel = input.nextLine();

                // Validasi input data pengembara
                boolean pengembaraNamavalid = true;
                for (int c=0 ; c<pengembaraNama.length() ; c++) {
                    char ch = pengembaraNama.charAt(c);
                    if (!(Character.isLetterOrDigit(ch) || ch == " ".charAt(0))) {
                    pengembaraNamavalid = false;
                    }
                }

                boolean pengembaraLevelValid = true;
                int pengembaraLevelInt = Integer.parseInt(pengembaraLevel);
                if (pengembaraLevelInt <= 0) {
                    pengembaraLevelValid = false;
                }
                else if ((pengembaraLevelInt - 20) > 0) {
                    pengembaraLevelValid = false;
                }

                pengembaraDataValid = (pengembaraNamavalid && pengembaraLevelValid);
                if (pengembaraDataValid) {
                    travelerData = travelerData + pengembaraNama +"|"+ pengembaraLevel +"|"+ "0" +"|"+ "kosong\u2705" + "$";
                    System.out.println("Pengembara berhasil ditambahkan.");
                }
                else {
                    System.out.println("Input tidak valid. Harap masukkan data dengan benar.");
                }
            }
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
                // Menampilkan daftar quest
                case "1":
                    int temp_pointer1 = 0;

                    // Menghitung total quest yang ada
                    int totalQuest = 0;
                    for (int i=0 ; i<questData.length() ; i++){
                        if ((questData.charAt(i)) == "$".charAt(0)){
                            totalQuest++;
                        }
                    }

                    // Loop untuk setiap quest
                    for (int i=1; i<=totalQuest; i++) {
                        // Inisialisasi variable sementara untuk diisi data dari daftar quest kemudian diprint dalam loop
                        String temp_questID = "";
                        String temp_questName = "";
                        String temp_questDesc = "";
                        String temp_questReward = "";
                        String temp_questExp = "";
                        String temp_questDifficulty = "";
                        String temp_questStatus = "";

                        // Loop untuk memisahkan quest 1 dengan yang lainnya
                        for (int j=temp_pointer1 ; j<questData.length() ; j++){
                            if ((questData.charAt(j)) == "$".charAt(0)){
                                int temp_pointer2 = temp_pointer1;
                                int temp_pointer3 = temp_pointer1;

                                // pointer1 menunjuk dimana bagian akhir dari data-data sebuah quest
                                temp_pointer1 = j+1;
                                // switch untuk menaruh data dalam urutan yang benar
                                int temp_switch = 0;
                                
                                // Loop untuk setiap elemen dalam 1 quest
                                for (int k=temp_pointer3 ; k<=j ; k++) {
                                    if (questData.charAt(k) == "|".charAt(0) || questData.charAt(k) == "$".charAt(0)){

                                        // Memindahkan pointer2 ke index akhir dari unsur sebuah quest
                                        temp_pointer2 = k;

                                        temp_switch++;
                                        switch (temp_switch) {
                                            // Quest ID
                                            case 1:
                                                temp_questID = questData.substring(temp_pointer3, temp_pointer2);
                                                break;
                                            
                                            // Quest Name
                                            case 2:
                                                temp_questName = questData.substring(temp_pointer3, temp_pointer2);
                                                break;
                                        
                                            // Quest Description
                                            case 3:
                                                temp_questDesc = questData.substring(temp_pointer3, temp_pointer2);
                                                break;
                                        
                                            // Quest Reward
                                            case 4:
                                                temp_questReward = questData.substring(temp_pointer3, temp_pointer2);
                                                break;
                                        
                                            // Quest Bonus Exp
                                            case 5:
                                                temp_questExp = questData.substring(temp_pointer3, temp_pointer2);
                                                break;
                                        
                                            // Quest Difficulty
                                            case 6:
                                                temp_questDifficulty = questData.substring(temp_pointer3, temp_pointer2);
                                                break;
            
                                            // Quest Status
                                            case 7:
                                                temp_questStatus = questData.substring(temp_pointer3, temp_pointer2);
                                                break;
                                        
                                            default:
                                                break;
                                        }

                                    // Memindahkan pointer3 ke awal unsur data untuk loop k berikutnya
                                    temp_pointer3 = temp_pointer2+1;
                                    }
                                }
                                // Menghentikan loop j setelah 1 quest ketemu
                                break;
                            }
                        }
                        
                        // Print data ke terminal
                        System.out.println("ID Quest: "+temp_questID);
                        System.out.println("Nama Quest: "+temp_questName);
                        System.out.println("Deskripsi Quest: "+temp_questDesc);
                        System.out.println("Reward Quest: "+temp_questReward+" koin" );
                        System.out.println("Bonus EXP Quest: "+temp_questExp+" poin exp");
                        System.out.println("Tingkat Kesulitan Quest: "+temp_questDifficulty);
                        System.out.println("Status Quest: "+temp_questStatus);
                        System.out.println();
                    }
                    
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
