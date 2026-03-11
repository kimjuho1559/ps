SELECT a.APNT_NO, p.PT_NAME, p.PT_NO, a.MCDP_CD, d.DR_NAME, a.APNT_YMD
from PATIENT p
join APPOINTMENT a
on p.PT_NO = a.PT_NO
join DOCTOR d
on a.MDDR_ID = d.DR_ID
where a.APNT_CNCL_YN like 'N' and date(a.APNT_YMD) = '2022-04-13' and a.MCDP_CD like 'CS'
order by a.APNT_YMD ASC;
