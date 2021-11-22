import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class DockerGenerator {
	public static void main(String[] args) throws IOException {
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
FileInputStream fin=new FileInputStream("C:\\Users\\MOSAIF\\BDD\\CucumberJava\\jenkinsprop.properties");
Properties prop=new Properties();
prop.load(fin);
String tags=prop.getProperty("tags");
System.out.println(tags);
FileWriter fout=new FileWriter("C:\\Users\\MOSAIF\\BDD\\CucumberJava\\Dockerfile");
fout.write("#base image of JDK(First Layer)\r\n"
		+ "FROM openjdk\r\n"
		+ "\r\n"
		+ "#Second layer in which the making the directory to run in.\r\n"
		+ "\r\n"
		+ "RUN mkdir /app\r\n"
		+ "\r\n"
		+ "\r\n"
		+ "COPY . /app\r\n"
		+ "\r\n"
		+ "\r\n"
		+ "WORKDIR /app/src/test/java/Step\r\n"
		+ "\r\n"
		+ "\r\n"
		+ "RUN javac TestRunner.java\r\n"
		+ "\r\n"
		+ "\r\n"
		+ "# base image for Maven Repositories\r\n"
		+ "\r\n"
		+ "From maven\r\n"
		+ "\r\n"
		+ "COPY . /app\r\n"
		+ "\r\n"
		+ "WORKDIR /app\r\n"
		+ "\r\n"
		+ "\r\n"
		+ "CMD mvn clean test");
fout.close();
	}

}
