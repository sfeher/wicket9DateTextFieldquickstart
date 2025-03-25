package com.mycompany.quick9;



import java.text.DateFormat;

import java.util.Date;
import java.util.Locale;
import java.util.logging.Logger;
import org.apache.wicket.extensions.markup.html.form.DateTextField;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

public class HomePage extends WebPage {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(HomePage.class.getName());

    //Date fDate=new Date();
    
    //IModel model = new Model<Date>(fDate);

    public HomePage(final PageParameters parameters) {
        super(parameters);

        Entity entity=new Entity();
        
        IModel<Entity> model=new Model(entity);
        
        DateTextField from = new DateTextField("fDate", new PropertyModel(model,"fDate"),"yyyy.MM.dd");
        
        FeedbackPanel fb=new FeedbackPanel("fb");
        add(fb);

        Form form = new Form("form",model) {

            @Override
            protected void onSubmit() {
                Locale locale = new Locale("hu_HU");
                DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, locale);
                String v = from.getValue();
                LOG.info("onSubmit " + v + " DateFormat.SHORT " + df.format(new Date()));

            }

            @Override
            protected void onError() {
                Locale locale = new Locale("hu_HU");
                DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, locale);
                String v = from.getValue();                
                LOG.info("onError " + v + " DateFormat.SHORT " + df.format(new Date()));
                super.onError();

            }
        };
        form.add(from);
        add(form);
        
    }



}
