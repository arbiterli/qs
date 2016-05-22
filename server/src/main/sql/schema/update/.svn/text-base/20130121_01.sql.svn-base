UPDATE `qualitysystem`.record_metric r SET r.type='RUN_QUALITY', r.name='INVALID_CHANGE' WHERE r.type='SERVER_CHANGE_CHECK' AND r.name='TOTAL_TICKETS';
UPDATE `qualitysystem`.record_metric r SET r.newvalue='no' WHERE r.newvalue='0' AND r.name='INVALID_CHANGE' AND r.type='RUN_QUALITY';
UPDATE `qualitysystem`.record_metric r SET r.newvalue='yes' WHERE r.newvalue<>'0' AND r.newvalue<>'no' AND r.name='INVALID_CHANGE' AND r.type='RUN_QUALITY';
UPDATE `qualitysystem`.record_metric r SET r.type='RUN_QUALITY' WHERE r.type='SERVER_MONITORING' AND r.name='AVERAGE_SLA';
DELETE FROM `qualitysystem`.record_metric  WHERE record_metric.type='SERVER_CHANGE_CHECK' OR record_metric.type='SERVER_MONITORING';


