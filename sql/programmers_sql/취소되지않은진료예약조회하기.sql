SELECT apnt_no, pt_name, patient.pt_no, doctor.mcdp_cd, dr_name, apnt_ymd
FROM patient JOIN (
SELECT mddr_id, pt_no, apnt_no, mcdp_cd, apnt_ymd
FROM appointment
WHERE mcdp_cd = 'CS' AND DATE_FORMAT(apnt_ymd, '%Y-%m-%d') = '2022-04-13' AND apnt_cncl_yn = 'N'
) AS tmp
ON patient.pt_no = tmp.pt_no
JOIN doctor
ON tmp.mddr_id = doctor.dr_id
ORDER BY apnt_ymd