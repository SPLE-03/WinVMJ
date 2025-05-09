package healthcare.consultation.chatconsultation;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import healthcare.consultation.core.ConsultationResourceDecorator;
import healthcare.consultation.core.ConsultationImpl;
import healthcare.consultation.core.ConsultationComponent;
import healthcare.consultation.core.Consultation;
import healthcare.consultation.core.ConsultationResourceComponent;
import healthcare.consultation.ConsultationFactory;
import vmj.hibernate.integrator.RepositoryUtil;
import healthcare.consultation.chatconsultation.ChatMessage;

public class ConsultationResourceImpl extends ConsultationResourceDecorator {
    private RepositoryUtil<Consultation> Repository;
    
    public ConsultationResourceImpl(ConsultationResourceComponent record) {
        super(record);
        this.Repository = new RepositoryUtil<Consultation>(healthcare.consultation.core.ConsultationComponent.class);
    }

    // @Restriced(permission = "")
    @Route(url="call/chatconsultation/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
        if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
            return null;
        }
        Consultation consultation = create(vmjExchange);
        Repository.saveObject(consultation);
        return getAll(vmjExchange);
    }

    public Consultation create(VMJExchange vmjExchange){
        // Get the data from the request to create the base consultation
        Map<String, Object> requestData = vmjExchange.getPayload();
        
        // Get or create the consultation data via the parent implementation
        HashMap<String, Object> baseConsultationData = record.createConsultation(vmjExchange);
        
        // Create a new ConsultationImpl object with the returned data
        String consultationSubject = (String) baseConsultationData.get("consultationSubject");
        String consultationDescription = (String) baseConsultationData.get("consultationDescription");
        boolean consultationStatus = (boolean) baseConsultationData.get("consultationStatus");
        
        // Initialize the list of chat messages
        List<ChatMessage> listChatMessages = new ArrayList<>();
        
        // Create the consultation component
        ConsultationComponent baseComponent = new healthcare.consultation.core.ConsultationImpl(
            UUID.randomUUID(),
            consultationSubject,
            consultationDescription,
            consultationStatus
        );
        
        // Create the decorated consultation
        Consultation deco = ConsultationFactory.createConsultation(
            "healthcare.consultation.chatconsultation.ConsultationImpl", 
            baseComponent, 
            listChatMessages
        );
        
        return deco;
    }

    public Consultation create(VMJExchange vmjExchange, int id){
        Consultation saved = Repository.getObject(id);
        ConsultationComponent baseRecord = (ConsultationComponent)saved;
        
        // Get data from the request
        Map<String, Object> requestData = vmjExchange.getPayload();
        
        // Get consultation data via the parent implementation
        HashMap<String, Object> baseConsultationData = record.createConsultation(vmjExchange);
        
        // Create a new ConsultationImpl object with the returned data
        String consultationSubject = (String) baseConsultationData.get("consultationSubject");
        String consultationDescription = (String) baseConsultationData.get("consultationDescription");
        boolean consultationStatus = (boolean) baseConsultationData.get("consultationStatus");
        
        // Initialize chat messages - might need to get existing ones or create new
        List<ChatMessage> listChatMessages = new ArrayList<>();
        
        // Create the consultation component with the existing ID
        ConsultationComponent baseComponent = new healthcare.consultation.core.ConsultationImpl(
            UUID.fromString(String.valueOf(id)),
            consultationSubject,
            consultationDescription,
            consultationStatus
        );
        
        // Create the decorated consultation
        Consultation deco = ConsultationFactory.createConsultation(
            "healthcare.consultation.chatconsultation.ConsultationImpl", 
            baseComponent, 
            listChatMessages
        );
        
        return deco;
    }

    // @Restriced(permission = "")
    @Route(url="call/chatconsultation/update")
    public HashMap<String, Object> update(VMJExchange vmjExchange){
        if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
            return null;
        }
        String idStr = (String) vmjExchange.getRequestBodyForm("id");
        int id = Integer.parseInt(idStr);
        
        Consultation consultation = Repository.getObject(id);
        consultation = create(vmjExchange, id);
        
        Repository.updateObject(consultation);
        consultation = Repository.getObject(id);
        //to do: fix association attributes
        
        return consultation.toHashMap();
    }

    // @Restriced(permission = "")
    @Route(url="call/chatconsultation/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
        return record.getConsultation(vmjExchange);
    }

    // @Restriced(permission = "")
    @Route(url="call/chatconsultation/list")
    public List<HashMap<String,Object>> getAll(VMJExchange vmjExchange){
        List<Consultation> list = Repository.getAllObject("consultation_impl");
        return transformListToHashMap(list);
    }

    public List<HashMap<String,Object>> transformListToHashMap(List<Consultation> list){
        List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < list.size(); i++) {
            resultList.add(list.get(i).toHashMap());
        }

        return resultList;
    }

    // @Restriced(permission = "")
    @Route(url="call/chatconsultation/delete")
    public List<HashMap<String,Object>> deleteConsultation(VMJExchange vmjExchange){
        if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
            return null;
        }
        
        String idStr = (String) vmjExchange.getRequestBodyForm("id");
        int id = Integer.parseInt(idStr);
        Repository.deleteObject(id);
        return getAll(vmjExchange);
    }
}