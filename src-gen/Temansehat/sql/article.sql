INSERT INTO information_comp (informationid, informationdescription, informationtitle, objectname, modulesequence) VALUES
    ('1219ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Understanding the importance of regular health check-ups', 'Health Check-ups Guide', 'healthcare.information.core.InformationComponent', NULL),
    ('2119ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Understanding the importance of regular health check-ups', 'Health Check-ups Guide', 'healthcare.information.core.InformationComponent', 'information_impl, information_article'),
    ('1319ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Tips for maintaining a healthy lifestyle', 'Healthy Living Tips', 'healthcare.information.core.InformationComponent', NULL),
    ('3119ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Tips for maintaining a healthy lifestyle', 'Healthy Living Tips', 'healthcare.information.core.InformationComponent', 'information_impl, information_article'),
    ('1419ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Common health myths debunked', 'Health Myths Explained', 'healthcare.information.core.InformationComponent', NULL),
    ('4119ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Common health myths debunked', 'Health Myths Explained', 'healthcare.information.core.InformationComponent', 'information_impl, information_article'),
    ('1519ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Nutrition guide for better health', 'Healthy Eating Guide', 'healthcare.information.core.InformationComponent', NULL),
    ('5119ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Nutrition guide for better health', 'Healthy Eating Guide', 'healthcare.information.core.InformationComponent', 'information_impl, information_article'),
    ('1619ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Exercise routines for different age groups', 'Fitness for All Ages', 'healthcare.information.core.InformationComponent', NULL),
    ('6119ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Exercise routines for different age groups', 'Fitness for All Ages', 'healthcare.information.core.InformationComponent', 'information_impl, information_article')
ON CONFLICT (informationid) DO NOTHING;

INSERT INTO information_impl (informationid) VALUES 
    ('2119ff33-6dd2-4c0a-b113-a90ee32a01ca'),
    ('3119ff33-6dd2-4c0a-b113-a90ee32a01ca'),
    ('4119ff33-6dd2-4c0a-b113-a90ee32a01ca'),
    ('5119ff33-6dd2-4c0a-b113-a90ee32a01ca'),
    ('6119ff33-6dd2-4c0a-b113-a90ee32a01ca')
ON CONFLICT (informationid) DO NOTHING;

INSERT INTO information_article (informationid, record_informationid, base_component_id, recordname, content) VALUES 
    ('1219ff33-6dd2-4c0a-b113-a90ee32a01ca', '2119ff33-6dd2-4c0a-b113-a90ee32a01ca', '2119ff33-6dd2-4c0a-b113-a90ee32a01ca', 'healthcare.information.core.InformationImpl', 'Regular health check-ups are essential for early disease detection and prevention. Schedule annual physicals, dental visits, and age-appropriate screenings. Keep track of your medical history and maintain open communication with healthcare providers.'),
    ('1319ff33-6dd2-4c0a-b113-a90ee32a01ca', '3119ff33-6dd2-4c0a-b113-a90ee32a01ca', '3119ff33-6dd2-4c0a-b113-a90ee32a01ca', 'healthcare.information.core.InformationImpl', 'Maintain a balanced diet, stay hydrated, and get 7-9 hours of sleep. Exercise regularly, manage stress through meditation, and avoid smoking and excessive alcohol. Regular health check-ups and preventive care are key to long-term wellness.'),
    ('1419ff33-6dd2-4c0a-b113-a90ee32a01ca', '4119ff33-6dd2-4c0a-b113-a90ee32a01ca', '4119ff33-6dd2-4c0a-b113-a90ee32a01ca', 'healthcare.information.core.InformationImpl', 'Contrary to popular belief, cracking knuckles doesn''t cause arthritis. Cold weather doesn''t cause colds, and sugar doesn''t make children hyperactive. Understanding these myths helps make informed health decisions.'),
    ('1519ff33-6dd2-4c0a-b113-a90ee32a01ca', '5119ff33-6dd2-4c0a-b113-a90ee32a01ca', '5119ff33-6dd2-4c0a-b113-a90ee32a01ca', 'healthcare.information.core.InformationImpl', 'Focus on whole foods, lean proteins, and colorful vegetables. Limit processed foods and added sugars. Stay hydrated with water and practice portion control. Remember, a balanced diet is key to maintaining good health.'),
    ('1619ff33-6dd2-4c0a-b113-a90ee32a01ca', '6119ff33-6dd2-4c0a-b113-a90ee32a01ca', '6119ff33-6dd2-4c0a-b113-a90ee32a01ca', 'healthcare.information.core.InformationImpl', 'Children need active play and sports. Adults benefit from 150 minutes of moderate exercise weekly. Seniors should focus on balance, flexibility, and strength training. Always consult healthcare providers before starting new routines.')
ON CONFLICT (informationid) DO NOTHING;
