package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@ResponseBody
public class SkillsController {

    @GetMapping
    public String showList(){
        return """
                <html>
                    """ + getStyle() + """
                    <body>
                        <h1>Skills Tracker</h1>
                        <h2>We <span class='heart'>&hearts;</span> to learn the following skills:</h2>
                        <ol>
                            <li>Java</li>
                            <li>JavaScript</li>
                            <li>Python</li>
                        </ol>
                    </body>
                </html>
                """;
    }
    @GetMapping("form")
    public String showForm(){
        return """
                <html>
                    """ + getStyle() + """
                    <body>
                        <form action="result" method="post">
                            Hi! &#x1F44B<br/>What's your
                            <input type="text" name="name" placeholder="Name"><br/>
                            I'd <span class="heart">&hearts;</span> to know you your favorite programming skills.<br/>
                            What's your <input list="languages" name="firstLanguage" placeholder="First Favorite"><br/>
                            What's your <input list="languages" name="secondLanguage" placeholder="Second Favorite"><br/>
                            What's your <input list="languages" name="thirdLanguage" placeholder="Third Favorite"><br/>
                            <input type="submit" value="Here Ya Go!">
                        </form>
                    </body>
                    <datalist id='languages'>
                        <option value="Java">Java</option>
                        <option value="JavaScript">JavaScript</option>
                        <option value="HTML">HTML</option>
                        <option value="CSS">CSS</option>
                        <option value="TypeScript">TypeScript</option>
                        <option value="Spring Boot">Spring Boot</option>
                    </datalist>
                </html>
                """;
    }
    @PostMapping("result")
    public String showResultFromPost(@RequestParam String name, @RequestParam String firstLanguage, @RequestParam String secondLanguage, @RequestParam String thirdLanguage){
        return """
                <html>
                    """ + getStyle() + """
                    <body>
                        Nice to meet you, <h1>""" + name + """
                        !</h1>
                        I organized your responses in this neat little table.<br/>
                        Check it out!<br/>
                        <table>
                            <tr class='headerRow'>
                                <td>Order Chosen</td>
                                <td>Programming Skill</td>
                            </tr>
                            <tr>
                                <td>First</td>
                                <td>"""+ firstLanguage +"""
                                </td>
                            </tr>
                            <tr>
                                <td>Second</td>
                                <td>"""+ secondLanguage +"""
                                </td>
                            </tr>
                            <tr>
                                <td>Third</td>
                                <td>"""+ thirdLanguage +"""
                                </td>
                            </tr>
                        </table>
                        <br/>
                        I really <span class="heart">&hearts; &hearts; &hearts;</span> all of those too!
                    </body>
                </html>
                """;
    }

    private String getStyle(){
        return """
                <style>
                        body{
                            padding: 5px;
                            background: linear-gradient(black,blue);
                            width: 80%;
                            display: flex;
                            flex-direction: column;
                            align-items: center;
                            color: white;
                            text-align: center;
                        }
                        .heart{
                            color: red;
                        }
                        form{
                            width: 50%;
                            border-radius: 10px;
                            border: 5px ridge gold;
                            box-shadow: 3px 3px 5px black;
                            padding: 10px;
                        }
                        .headerRow{
                            text-decoration: underline;
                            background: linear-gradient(black,darkgray);
                        }
                        td{
                            padding: 5px;
                            text-align: center;
                        }
                        table{
                            border: 1px solid darkgray;
                        }
                    </style>
                """;
    }
}
