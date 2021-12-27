## Image-metadata-features
Backend application capable of working with image metadata


Steps to setup in local

Clone Repo : git clone https://github.com/Gyan0522/image-metadata-features.git

Traverse to image-metadata-features folder in local system using terminal

Run Springboot application : ./mvnw spring-boot:run (run command  "mvn -N io.takari:maven:wrapper" if ./mvnw: No such file or directory error)
### Execute the Endpoints (using post man)

1.  http://localhost:8080/features
2.  http://localhost:8080/features/12d0b505-2c70-4420-855c-936d05c55669
3.  http://localhost:8080/features/39c2f29e-c0f8-4a39-a98b-deed547d6aea/quicklook 


### Execute the Endpoints (using curl) 
open a new terminal and execute below commands

1. curl http://localhost:8080/features
2. curl  http://localhost:8080/features/12d0b505-2c70-4420-855c-936d05c55669
