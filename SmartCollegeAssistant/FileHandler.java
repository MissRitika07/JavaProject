import java.io.*;

class FileHandler {

    // 👉 Save Student (No Duplicate)
    static void saveStudent(Student s) {
        try {
            File file = new File("students.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(" ");
                if (data[1].equals(String.valueOf(s.id))) {
                    System.out.println("Student already exists!");
                    br.close();
                    return;
                }
            }
            br.close();

            FileWriter fw = new FileWriter(file, true);
            fw.write(s.name + " " + s.id + " " + s.attendance + "\n");
            fw.close();

        } catch (Exception e) {
            e.printStackTrace(); // shows real error
        }
    }

    // 👉 Read Students
    static String readStudents() {
        String data = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("students.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                data += line + "\n";
            }
            br.close();

        } catch (Exception e) {
            data = "No Data Found";
        }
        return data;
    }

    // 👉 Update Student
    static void updateStudent(String id, String newName) {
        try {
            File input = new File("students.txt");
            File temp = new File("temp.txt");

            BufferedReader br = new BufferedReader(new FileReader(input));
            BufferedWriter bw = new BufferedWriter(new FileWriter(temp));

            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(" ");

                if (data[1].equals(id)) {
                    bw.write(newName + " " + id + " " + data[2]);
                } else {
                    bw.write(line);
                }
                bw.newLine();
            }

            br.close();
            bw.close();

            input.delete();
            temp.renameTo(input);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 👉 Delete Student
    static void deleteStudent(String id) {
        try {
            File input = new File("students.txt");
            File temp = new File("temp.txt");

            BufferedReader br = new BufferedReader(new FileReader(input));
            BufferedWriter bw = new BufferedWriter(new FileWriter(temp));

            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(" ");

                if (!data[1].equals(id)) {
                    bw.write(line);
                    bw.newLine();
                }
            }

            br.close();
            bw.close();

            input.delete();
            temp.renameTo(input);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}