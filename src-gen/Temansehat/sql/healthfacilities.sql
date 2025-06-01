INSERT INTO information_comp (informationid, informationdescription, informationtitle, objectname, modulesequence) VALUES
    ('a1b2c3d4-e5f6-4789-a123-b456c789d012', 'Rumah sakit umum dengan pelayanan 24 jam dan fasilitas gawat darurat lengkap', 'RS Harapan Sehat', 'healthcare.information.core.InformationComponent', NULL),
    ('b2c3d4e5-f6a7-4890-b234-c567d890e123', 'Rumah sakit umum dengan pelayanan 24 jam dan fasilitas gawat darurat lengkap', 'RS Harapan Sehat', 'healthcare.information.core.InformationComponent', 'information_impl, information_healthfacilities'),
    ('c3d4e5f6-a7b8-4901-c345-d678e901f234', 'Klinik spesialis mata dengan teknologi laser terdepan', 'Klinik Mata Cahaya', 'healthcare.information.core.InformationComponent', NULL),
    ('d4e5f6a7-b8c9-4012-d456-e789f012a345', 'Klinik spesialis mata dengan teknologi laser terdepan', 'Klinik Mata Cahaya', 'healthcare.information.core.InformationComponent', 'information_impl, information_healthfacilities'),
    ('e5f6a7b8-c9d0-4123-e567-f890a123b456', 'Puskesmas dengan layanan kesehatan masyarakat dan imunisasi', 'Puskesmas Sehat Bersama', 'healthcare.information.core.InformationComponent', NULL),
    ('f6a7b8c9-d0e1-4234-f678-9012b345c678', 'Puskesmas dengan layanan kesehatan masyarakat dan imunisasi', 'Puskesmas Sehat Bersama', 'healthcare.information.core.InformationComponent', 'information_impl, information_healthfacilities'),
    ('a7b8c9d0-e1f2-4345-a789-0123c456d789', 'Apotek lengkap dengan konsultasi farmasi gratis', 'Apotek Kimia Farma Plus', 'healthcare.information.core.InformationComponent', NULL),
    ('b8c9d0e1-f2a3-4456-b890-1234d567e890', 'Apotek lengkap dengan konsultasi farmasi gratis', 'Apotek Kimia Farma Plus', 'healthcare.information.core.InformationComponent', 'information_impl, information_healthfacilities'),
    ('c9d0e1f2-a3b4-4567-c901-2345e678f901', 'Laboratorium klinik dengan hasil tes cepat dan akurat', 'Lab Diagnostik Prima', 'healthcare.information.core.InformationComponent', NULL),
    ('d0e1f2a3-b4c5-4678-d012-3456f789a012', 'Laboratorium klinik dengan hasil tes cepat dan akurat', 'Lab Diagnostik Prima', 'healthcare.information.core.InformationComponent', 'information_impl, information_healthfacilities')
ON CONFLICT (informationid) DO NOTHING;

INSERT INTO information_impl (informationid) VALUES 
    ('b2c3d4e5-f6a7-4890-b234-c567d890e123'),
    ('d4e5f6a7-b8c9-4012-d456-e789f012a345'),
    ('f6a7b8c9-d0e1-4234-f678-9012b345c678'),
    ('b8c9d0e1-f2a3-4456-b890-1234d567e890'),
    ('d0e1f2a3-b4c5-4678-d012-3456f789a012')
ON CONFLICT (informationid) DO NOTHING;

INSERT INTO information_healthfacilities (informationid, record_informationid, base_component_id, recordname, location) VALUES 
    ('a1b2c3d4-e5f6-4789-a123-b456c789d012', 'b2c3d4e5-f6a7-4890-b234-c567d890e123', 'b2c3d4e5-f6a7-4890-b234-c567d890e123', 'healthcare.information.core.InformationImpl', 'Jl. Sudirman No. 45, Jakarta Pusat, DKI Jakarta 10220'),
    ('c3d4e5f6-a7b8-4901-c345-d678e901f234', 'd4e5f6a7-b8c9-4012-d456-e789f012a345', 'd4e5f6a7-b8c9-4012-d456-e789f012a345', 'healthcare.information.core.InformationImpl', 'Jl. Gatot Subroto No. 123, Bandung, Jawa Barat 40263'),
    ('e5f6a7b8-c9d0-4123-e567-f890a123b456', 'f6a7b8c9-d0e1-4234-f678-9012b345c678', 'f6a7b8c9-d0e1-4234-f678-9012b345c678', 'healthcare.information.core.InformationImpl', 'Jl. Diponegoro No. 78, Surabaya, Jawa Timur 60264'),
    ('a7b8c9d0-e1f2-4345-a789-0123c456d789', 'b8c9d0e1-f2a3-4456-b890-1234d567e890', 'b8c9d0e1-f2a3-4456-b890-1234d567e890', 'healthcare.information.core.InformationImpl', 'Jl. Ahmad Yani No. 234, Yogyakarta, DI Yogyakarta 55232'),
    ('c9d0e1f2-a3b4-4567-c901-2345e678f901', 'd0e1f2a3-b4c5-4678-d012-3456f789a012', 'd0e1f2a3-b4c5-4678-d012-3456f789a012', 'healthcare.information.core.InformationImpl', 'Jl. Veteran No. 89, Medan, Sumatera Utara 20112')
ON CONFLICT (informationid) DO NOTHING;