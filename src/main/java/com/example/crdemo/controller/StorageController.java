package com.example.crdemo.controller;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.StorageException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/data")
public class StorageController {

    @GetMapping("/empdata")
    public String getEmployeeData() throws IOException {

            // Create a Storage service object (assuming you have proper authentication configured)
            Storage storage = StorageOptions.getDefaultInstance().getService();

            // Define the bucket and object names
            String bucketName = "pmtmbucket002";
            String objectName = "json/json_file.json";

            // Get the blob from the bucket
            BlobId blobId = BlobId.of(bucketName, objectName);
            Blob blob = storage.get(blobId);

            // Read the content of the blob
            byte[] content = blob.getContent();
            System.out.println(new String(content));
            return new String(content);
        }
    }