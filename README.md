# copy-properties-assembler

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/18f61bb26a6046d29f679aeb2f6d7cf5)](https://app.codacy.com/app/marcosvidolin/copy-properties-assembler?utm_source=github.com&utm_medium=referral&utm_content=marcosvidolin/copy-properties-assembler&utm_campaign=Badge_Grade_Dashboard)
[![Build Status](https://travis-ci.org/marcosvidolin/copy-properties-assembler.svg?branch=master)](https://travis-ci.org/marcosvidolin/copy-properties-assembler)

A simple copy properties wrapper to convert domain into resource/dto and vice versa.

## Setup

Gragle

```groovy
compile 'com.vidolima:copy-properties-assembler:v1.1.0'
```

## How to use

Domain class
```java
@Entity
public class User {
  private String firstname;
  private String lastname;
  private String username;
  private String email;
  private String birthdate;
  // ...
}
```

Resource class
```java
public class FullUserResource {
  private String firstname;
  private String lastname;
  private String username;
  private String email;
  private String birthdate;
  // ...
}
```

Resource class
```java
public class BasicUserResource {
  private String firstname;
  private String username;
  // ...
}
```

Assembler 
```java
public class UserAssembler extends GenericResourceAssembler<UserDomain> {
  public UserAssembler() {
    super(UserDomain.class);
  }
}
```

Controller
```java
@RestController
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
class UserController {
  
  private UserAssembler assembler = new UserAssember();

  /** Will return the basic user information. */
  @GetMapping(path = "/users/{username}")
  public ResponseEntity getBasicUser(@PathVariable String username) {
    User domain = this.service.findUserByUsername(username);
    BasicUserResource resource = this.assembler.fromDomain(domain, BasicUserResource.class);
    return ResponseEntity.ok(resource);
  }
  
  /** Will return all the user information. */
  @GetMapping(path = "/admin/users/{username}")
  public ResponseEntity getBasicUser(@PathVariable String username) {
    User domain = this.service.findUserByUsername(username);
    FullUserResource resource = this.assembler.fromDomain(domain, FullUserResource.class);
    return ResponseEntity.ok(resource);
  }

}
```

## Contributors

[![](https://sourcerer.io/fame/marcosvidolin/marcosvidolin/copy-properties-assembler/images/0)](https://sourcerer.io/fame/marcosvidolin/marcosvidolin/copy-properties-assembler/links/0)[![](https://sourcerer.io/fame/marcosvidolin/marcosvidolin/copy-properties-assembler/images/1)](https://sourcerer.io/fame/marcosvidolin/marcosvidolin/copy-properties-assembler/links/1)[![](https://sourcerer.io/fame/marcosvidolin/marcosvidolin/copy-properties-assembler/images/2)](https://sourcerer.io/fame/marcosvidolin/marcosvidolin/copy-properties-assembler/links/2)[![](https://sourcerer.io/fame/marcosvidolin/marcosvidolin/copy-properties-assembler/images/3)](https://sourcerer.io/fame/marcosvidolin/marcosvidolin/copy-properties-assembler/links/3)[![](https://sourcerer.io/fame/marcosvidolin/marcosvidolin/copy-properties-assembler/images/4)](https://sourcerer.io/fame/marcosvidolin/marcosvidolin/copy-properties-assembler/links/4)[![](https://sourcerer.io/fame/marcosvidolin/marcosvidolin/copy-properties-assembler/images/5)](https://sourcerer.io/fame/marcosvidolin/marcosvidolin/copy-properties-assembler/links/5)[![](https://sourcerer.io/fame/marcosvidolin/marcosvidolin/copy-properties-assembler/images/6)](https://sourcerer.io/fame/marcosvidolin/marcosvidolin/copy-properties-assembler/links/6)[![](https://sourcerer.io/fame/marcosvidolin/marcosvidolin/copy-properties-assembler/images/7)](https://sourcerer.io/fame/marcosvidolin/marcosvidolin/copy-properties-assembler/links/7)
