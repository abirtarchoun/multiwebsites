package app.igesa.controller;
import app.igesa.dto.RoleDTO;
import app.igesa.metiers.RoleImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.Optional;

@RestController
@Api(tags = "ROLE")
public class RoleController {

    private static final Logger log = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleImpl iroleService;


    @RequestMapping(value="/role",method = RequestMethod.POST)
    @ApiOperation(value="ADD ROLE",notes="SAUVGARDER ROLE", response = RoleDTO.class)
    @ApiResponses(value= {
            @ApiResponse(code=200,message="Entreprise was saved Successfully"),
            @ApiResponse(code=400,message="Entreprise not valid"),
            @ApiResponse(code=401,message="Unauthorized , without authority or permission"),
            @ApiResponse( code=403, message="not permitted or allowed"),

    })
    ResponseEntity<RoleDTO> save( @RequestBody RoleDTO r) {
        log.debug(" HTTP POST {}",r);
        return new ResponseEntity<> (iroleService.save(r), HttpStatus.CREATED);
    }


    @RequestMapping(value="/role",method =RequestMethod.GET)
    @ApiOperation(value="GET A LIST OF ROLE", responseContainer  = "Collection<RoleDTo>")
    @ApiResponses(value= {
            @ApiResponse(code=200,message="Role  was found successfully"),
            @ApiResponse( code=404, message="Role Not found "),
            @ApiResponse(code=401,message="Unauthorized , without authority or permission"),
            @ApiResponse( code=403, message="not permitted or allowed"),

    })
    public ResponseEntity<Collection<RoleDTO>> view() {
        log.debug(" HTTP GET ALL ROLE {}");
        return new ResponseEntity<>( iroleService.findAll(),HttpStatus.OK);
    }


    @RequestMapping(value="/role/{id}",method =RequestMethod.GET)
    @ApiOperation(value=" GET ROLE  BY ID ",notes="GET AND SEARCH FOR ROLE  BY ID ", response = RoleDTO.class)
    @ApiResponses(value= {
            @ApiResponse(code=200,message="Role was found successfully with the provided id"),
            @ApiResponse(code=404,message="No Role is found with the provided id "),
            @ApiResponse(code=401,message="Unauthorized , without authority or permission"),
            @ApiResponse( code=403, message="not permitted or allowed"),

    })
    public ResponseEntity<Optional<RoleDTO>>findById(@PathVariable Long id) {
        log.debug(" HTTP GET ENTREPRISE BY ID {}",id);
        return new ResponseEntity<>( iroleService.findById(id),HttpStatus.OK);
    }


    @RequestMapping(value="/role",method =RequestMethod.PUT)
    @ApiOperation(value="UPDATE ROLE BY ID ",response = RoleDTO.class)
    @ApiResponses(value= {
            @ApiResponse(code=200,message="Role was updated successfully"),
            @ApiResponse(code=401,message="Unauthorized , without authority or permission"),
            @ApiResponse( code=403, message="not permitted or allowed"),

    })
    public ResponseEntity<RoleDTO> update( @RequestBody RoleDTO r) {
        return new ResponseEntity<>(iroleService.save(r),HttpStatus.CREATED);
    }

    @RequestMapping(value="/role/{id}",method =RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation(value="DELETE ROLE BY ID ",response = RoleDTO.class)
    @ApiResponses(value= {
            @ApiResponse(code=200,message="Role was Deleted successfully"),
            @ApiResponse(code=401,message="Unauthorized , without authority or permission"),
            @ApiResponse( code=403, message="not permitted or allowed")

    })
    public void delete(@PathVariable Long id) {

        log.debug(" HTTP DELETE ROLE BY ID {}",id);

        iroleService.delete(id);
    }



}
