CREATE TABLE tb_card_list
(
  MGT_ACCT_NO VARCHAR2(5) PRIMARY KEY NOT NULL,
  ST_DT VARCHAR2(8),
  END_DT VARCHAR2(8),
  CARD_STAT_CD VARCHAR2(2),
  CRDT_YN VARCHAR2(1),
  TOT_MLT_AMT NUMBER(12),
  TX_AGNC_CD VARCHAR2(6)
);