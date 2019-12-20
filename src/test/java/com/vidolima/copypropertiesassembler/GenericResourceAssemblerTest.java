package com.vidolima.copypropertiesassembler;

import com.vidolima.copypropertiesassembler.example.FullUserResource;
import com.vidolima.copypropertiesassembler.example.UserAssembler;
import com.vidolima.copypropertiesassembler.example.UserDomain;
import com.vidolima.copypropertiesassembler.example.UserResource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class GenericResourceAssemblerTest {

  private UserAssembler assembler = new UserAssembler();

  @Test
  public void fromResource_withNull_mustReturnNull() {
    UserDomain user = null;
    FullUserResource fullUserResource = this.assembler.fromDomain(user, FullUserResource.class);
    Assert.assertNull(fullUserResource);
  }

  @Test
  public void fromResource_withAllPropertiesNull_mustReturnObject() {
    UserDomain user = new UserDomain();
    FullUserResource fullUserResource = this.assembler.fromDomain(user, FullUserResource.class);
    Assert.assertNotNull(fullUserResource);
  }

  @Test
  public void fromResource_withOneFullObject_mustConvertAllFields() {
    UserDomain user = new UserDomain();
    user.setFirstname("John");
    user.setLastname("Connor");
    user.setUsername("johnconnor");
    user.setEmail("jconnor@skynet.com");
    user.setBirthdate(new Date());

    FullUserResource fullUserResource = this.assembler.fromDomain(user, FullUserResource.class);

    Assert.assertEquals(user.getFirstname(), fullUserResource.getFirstname());
    Assert.assertEquals(user.getLastname(), fullUserResource.getLastname());
    Assert.assertEquals(user.getUsername(), fullUserResource.getUsername());
    Assert.assertEquals(user.getEmail(), fullUserResource.getEmail());
    Assert.assertEquals(user.getBirthdate(), fullUserResource.getBirthdate());
  }

  @Test
  public void fromResource_withCollectionOfFullObject_mustConvertAllFields() {
    UserDomain jconnor = new UserDomain();
    jconnor.setFirstname("John");
    jconnor.setLastname("Connor");
    jconnor.setUsername("johnconnor");
    jconnor.setEmail("jconnor@skynet.com");
    jconnor.setBirthdate(new Date());

    UserDomain sconnor = new UserDomain();
    sconnor.setFirstname("Sarah");
    sconnor.setLastname("Connor");
    sconnor.setUsername("sarahconnor");
    sconnor.setEmail("sconnor@skynet.com");
    sconnor.setBirthdate(new Date());

    List<FullUserResource> fullUsersResource =
        (List<FullUserResource>) this.assembler.fromDomain(Arrays.asList(jconnor, sconnor), FullUserResource.class);

    Assert.assertEquals(jconnor.getFirstname(), fullUsersResource.get(0).getFirstname());
    Assert.assertEquals(jconnor.getLastname(), fullUsersResource.get(0).getLastname());
    Assert.assertEquals(jconnor.getUsername(), fullUsersResource.get(0).getUsername());
    Assert.assertEquals(jconnor.getEmail(), fullUsersResource.get(0).getEmail());
    Assert.assertEquals(jconnor.getBirthdate(), fullUsersResource.get(0).getBirthdate());

    Assert.assertEquals(sconnor.getFirstname(), fullUsersResource.get(1).getFirstname());
    Assert.assertEquals(sconnor.getLastname(), fullUsersResource.get(1).getLastname());
    Assert.assertEquals(sconnor.getUsername(), fullUsersResource.get(1).getUsername());
    Assert.assertEquals(sconnor.getEmail(), fullUsersResource.get(1).getEmail());
    Assert.assertEquals(sconnor.getBirthdate(), fullUsersResource.get(1).getBirthdate());
  }

  @Test
  public void fromResource_withOneObject_mustConvertAllFields() {
    UserDomain user = new UserDomain();
    user.setFirstname("John");
    user.setLastname("Connor");
    user.setUsername("johnconnor");
    user.setEmail("jconnor@skynet.com");
    user.setBirthdate(new Date());

    UserResource userResource = this.assembler.fromDomain(user, UserResource.class);

    Assert.assertEquals(user.getFirstname(), userResource.getFirstname());
    Assert.assertEquals(user.getUsername(), userResource.getUsername());
  }

  @Test
  public void fromResource_withCollection_mustConvertAllFields() {
    UserDomain jconnor = new UserDomain();
    jconnor.setFirstname("John");
    jconnor.setLastname("Connor");
    jconnor.setUsername("johnconnor");
    jconnor.setEmail("jconnor@skynet.com");
    jconnor.setBirthdate(new Date());

    UserDomain sconnor = new UserDomain();
    sconnor.setFirstname("Sarah");
    sconnor.setLastname("Connor");
    sconnor.setUsername("sarahconnor");
    sconnor.setEmail("sconnor@skynet.com");
    sconnor.setBirthdate(new Date());

    List<UserResource> usersResource =
        (List<UserResource>) this.assembler.fromDomain(Arrays.asList(jconnor, sconnor), UserResource.class);

    Assert.assertEquals(jconnor.getFirstname(), usersResource.get(0).getFirstname());
    Assert.assertEquals(jconnor.getUsername(), usersResource.get(0).getUsername());

    Assert.assertEquals(sconnor.getFirstname(), usersResource.get(1).getFirstname());
    Assert.assertEquals(sconnor.getUsername(), usersResource.get(1).getUsername());
  }

}