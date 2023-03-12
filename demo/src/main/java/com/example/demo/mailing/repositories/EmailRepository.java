package com.example.demo.mailing.repositories;

import com.example.demo.mailing.models.EmailDetails;
import org.springframework.stereotype.Repository;

@Repository

public interface EmailRepository {

    String sendSimpleMailToMany(EmailDetails emailDetails);
    String sendSimpleMail(EmailDetails emailDetails);
    String sendMailWithAttachmentToMany(EmailDetails emailDetails);
    String sendMailWithAttachment(EmailDetails emailDetails);
}
