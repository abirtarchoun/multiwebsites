package app.igesa.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Collection;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import app.igesa.dto.GroupeDTO;
import app.igesa.metiers.Igroupe;

@RestController
@Api(tags = "GROUPE")
public class GroupeController {
	
	private static final Logger log = LoggerFactory.getLogger(GroupeController.class);
	@Autowired
	private Igroupe groupeservice;

	public GroupeController(Igroupe groupeservice) {
		super();
		this.groupeservice = groupeservice;
	}
	

	@RequestMapping(value="/groupe",method =RequestMethod.POST)
	@ApiOperation(value="ADD GROUPE",notes="SAUVGARDER GROUPE", response = GroupeDTO.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Groupe was saved Successfully"),
			@ApiResponse(code=400,message="Groupe not valid"),
			@ApiResponse(code=401,message="Unauthorized , without authority or permission"),
			@ApiResponse( code=403, message="not permitted or allowed"),

	})
	public GroupeDTO save(@RequestBody GroupeDTO g) {
		log.debug(" HTTP POST {}",g);
		return groupeservice.save(g);
	}
	

	@RequestMapping(value="/groupe",method =RequestMethod.GET)
	@ApiOperation(value="GET A LIST OF GROUPE ", responseContainer  = "Collection<GroupeDTO>")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Groupe was found successfully"),
			@ApiResponse( code=404, message="GroupeNot found "),
			@ApiResponse(code=401,message="Unauthorized , without authority or permission"),
			@ApiResponse( code=403, message="not permitted or allowed"),

	})
	public Collection<GroupeDTO> view() {
		log.debug(" HTTP GET  ALL GROUPE {}");
		return groupeservice.view();
	}
	

	@RequestMapping(value="/groupe/{id}",method =RequestMethod.GET)
	@ApiOperation(value=" GET GROUPE BY ID ",notes="GET AND SEARCH FOR GROUPE BY ID ", response = GroupeDTO.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Groupe was found successfully with the provided id"),
			@ApiResponse(code=404,message="No Groupeis found with the provided id "),
			@ApiResponse(code=401,message="Unauthorized , without authority or permission"),
			@ApiResponse( code=403, message="not permitted or allowed"),

	})
	public GroupeDTO findById(@PathVariable Long id) {
		log.debug(" HTTP FIND BY ID {}",id);
		return groupeservice.findById(id);
	}

	@RequestMapping(value="/groupe/{id}",method =RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value="DELETE GROUPE BY ID ",response = GroupeDTO.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Groupe was Deleted successfully"),
			@ApiResponse(code=401,message="Unauthorized , without authority or permission"),
			@ApiResponse( code=403, message="not permitted or allowed")

	})
	public void delete(@PathVariable Long id) {
		log.debug(" HTTP DELETE {}",id);
		groupeservice.delete(id);
	}

	@RequestMapping(value="/groupe",method =RequestMethod.PUT)
	@ApiOperation(value="UPDATE GROUPE BY ID ",response = GroupeDTO.class)
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Groupe was updated successfully"),
			@ApiResponse(code = 401, message = "Unauthorized , without authority or permission"),
			@ApiResponse(code = 403, message = "not permitted or allowed"),
	})
	    public ResponseEntity<GroupeDTO> update(@RequestBody GroupeDTO g) {
		log.debug(" HTTP PUT {}");
		return new ResponseEntity<>(groupeservice.save(g), HttpStatus.CREATED);
	}
	@RequestMapping(value="/groupe/ALL",method =RequestMethod.GET)
	@ApiOperation(value="UPDATE GROUPE BY ID ",response = GroupeDTO.class)
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Groupe was updated successfully"),
			@ApiResponse(code = 401, message = "Unauthorized , without authority or permission"),
			@ApiResponse(code = 403, message = "not permitted or allowed"),
	})


	public GroupeDTO findAllById(@PathVariable Long id) {
		return groupeservice.findAllById(id);
	}
}
