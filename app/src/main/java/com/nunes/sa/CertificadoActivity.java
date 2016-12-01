package com.nunes.sa;

import android.graphics.Rect;
import android.graphics.pdf.PdfDocument;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CertificadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certificado);
    }

    public void btnPDF(View v) {
        try{
        String nomeDiretorio = "SA";
        String diretorioApp = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/"+nomeDiretorio+"/";
        File diretorio = new File(diretorioApp);
        diretorio.mkdirs();
        PdfDocument document = new PdfDocument();
        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(300, 300, 1).create();
        PdfDocument.Page page = document.startPage(pageInfo);
        View content = findViewById(R.id.txtTeste);
        content.draw(page.getCanvas());
        document.finishPage(page);
        ByteArrayOutputStream os = new ByteArrayOutputStream();

            document.writeTo(os);
            document.close();
            os.close();
            Toast.makeText(this, "Salvou", Toast.LENGTH_SHORT);
        }catch(IOException e){
            throw new RuntimeException("Erro ao gerar o PDF", e);

        }




    }
}
