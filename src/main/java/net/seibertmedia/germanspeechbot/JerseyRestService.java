package net.seibertmedia.germanspeechbot;

import com.sun.jersey.spi.resource.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("jsonServices")
@Singleton
public class JerseyRestService {
  private static final Logger logger = LoggerFactory.getLogger(JerseyRestService.class);

  Botrunner botrunner = new Botrunner();

  public JerseyRestService() {
    logger.debug("init JerseyRestService");
  }

  @GET
  @Path("/get/{req}")
  @Produces(MediaType.APPLICATION_JSON)
  public ChatResponse produceJSON(@PathParam("req") String req) {
    logger.debug("Incoming request {}", req);


    String answer = botrunner.answerRequest(req);

    return new ChatResponse(answer);
  }

}
