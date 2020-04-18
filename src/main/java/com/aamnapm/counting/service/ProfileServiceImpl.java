package com.aamnapm.counting.service;

import com.aamnapm.counting.dto.ResponseApi;
import com.aamnapm.counting.exeption.ConflictException;
import com.aamnapm.counting.exeption.NotFoundException;
import com.aamnapm.counting.exeption.RunTimeException;
import com.aamnapm.counting.model.Profile;
import com.aamnapm.counting.repository.ProfileRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.persistence.criteria.Predicate;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.CompletableFuture;

//import com.aamnapm.counting.model.Profile_;

@Service
public class ProfileServiceImpl implements ProfileService {

    private ProfileRepository profileRepository;
    @Value("/Users/reza/Desktop/aliProject/springboot/counting/src/main/java/com")
    private String reportPath;

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public ResponseApi save(Profile profile) {
        Optional<Profile> byNationalCode = profileRepository.findByNationalCode(profile.getNationalCode());

        if (!byNationalCode.isPresent()) {
            try {
                Profile profileSaved = profileRepository.save(profile);
                ResponseApi responseApi = new ResponseApi();
                responseApi.setMessage("User save success.");
                responseApi.setResult(profileSaved.getId());
                responseApi.setStatus(true);
                return responseApi;
            } catch (Exception e) {
                throw new RunTimeException(e.getMessage());
            }
        } else {
            throw new ConflictException("User already exist");
        }
    }

    @Override
    public void update(Profile profile, UUID uuid) {
        Optional<Profile> byId = profileRepository.findById(uuid);

        if (byId.isPresent()) {
            Profile profileBySearch = byId.get();
            profileBySearch.setAge(profile.getAge());
            profileBySearch.setName(profile.getName());
            profileBySearch.setFamily(profile.getFamily());
            profileBySearch.setNationalCode(profile.getNationalCode());
            profileRepository.save(profileBySearch);
        } else {
            throw new NotFoundException("Profile dose'nt exist");
        }
    }

    @Override
    public void delete(UUID uuid) {
        Optional<Profile> byId = profileRepository.findById(uuid);
        if (byId.isPresent()) {
            try {
                profileRepository.deleteById(uuid);
            } catch (Exception e) {
                throw new RunTimeException(e.getMessage());
            }
        } else {
            throw new NotFoundException("Profile dose'nt exist");
        }
    }

    @Override
    public List<Profile> getAll() {
        try {
            return profileRepository.findAll();
        } catch (Exception e) {
            throw new RunTimeException(e.getMessage());
        }
    }

    @Override
    public List<Profile> getAll(String name, int age, String family, String nationalCode) {

        List<Predicate> profileList = new ArrayList<>();
        try {
            Specification<Profile> result = (Specification<Profile>) (root, query, criteriaBuilder) -> {
//                if (name != null)
//                    profileList.add(criteriaBuilder.equal(root.get(Profile_.name), name));
//                if (age != -1)
//                    profileList.add(criteriaBuilder.equal(root.get(Profile_.age), age));
//                if (family != null)
//                    profileList.add(criteriaBuilder.equal(root.get(Profile_.family), family));
//                if (nationalCode != null)
//                    profileList.add(criteriaBuilder.equal(root.get(Profile_.nationalCode), nationalCode));
                return criteriaBuilder.and(profileList.toArray(new Predicate[0]));
            };

            return profileRepository.findAll(result);

        } catch (Exception e) {
            throw new RunTimeException(e.getMessage());
        }
    }

    @Override
    public Profile get(UUID uuid) {
        Optional<Profile> byId = profileRepository.findById(uuid);

        if (byId.isPresent()) {
            return byId.get();
        } else {
            throw new NotFoundException("Profile dose'nt exist");
        }
    }


    @Async
    @Override
    public CompletableFuture<String> getReport() {
        List<Profile> profileList = new ArrayList<>();
        profileRepository.findAll().stream().forEach(e -> profileList.add(e));

        try {
            File file = ResourceUtils.getFile("classpath:employeeReport.jrxml");

            InputStream input = new FileInputStream(file);

            // Compile the Jasper report from .jrxml to .japser

            JasperReport jasperReport = JasperCompileManager.compileReport(input);

            // Get your data source

            JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(profileList);

            // Add parameters

            Map<String, Object> parameters = new HashMap<>();

            parameters.put("createdBy", "JavaHelper.org");

            // Fill the report

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, source);

            // Export the report to a PDF file

            JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath + "\\Empployee.pdf");

            System.out.println("PDF File Generated !!");

            JasperExportManager.exportReportToXmlFile(jasperPrint, reportPath + "\\Employee.xml", true);

            System.out.println("XML File Generated !!");

            JasperExportManager.exportReportToHtmlFile(jasperPrint, reportPath + "\\Employee.html");

            System.out.println("HTML Generated");

            xlsx(jasperPrint);

            csv(jasperPrint);

            return CompletableFuture.completedFuture("Report successfully generated @path= " + reportPath);

        } catch (Exception e) {
            return CompletableFuture.completedFuture(e.getMessage());
        }
    }

    private void csv(JasperPrint jasperPrint) throws JRException {
        JRCsvExporter exporter = new JRCsvExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleWriterExporterOutput(reportPath + "\\Employee.csv"));
        SimpleCsvExporterConfiguration configuration = new SimpleCsvExporterConfiguration();
        configuration.setFieldDelimiter(",");
        exporter.setConfiguration(configuration);
        exporter.exportReport();
    }

    private void xlsx(JasperPrint jasperPrint) throws JRException {
        // Exports a JasperReports document to XLSX format. It has character output type and exports the document to a grid-based layout.
        JRXlsxExporter exporter = new JRXlsxExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(reportPath + "\\Employee.xlsx"));
        SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
        configuration.setOnePagePerSheet(true);
        configuration.setRemoveEmptySpaceBetweenColumns(true);
        configuration.setDetectCellType(true);
        exporter.setConfiguration(configuration);
        exporter.exportReport();
    }
}
