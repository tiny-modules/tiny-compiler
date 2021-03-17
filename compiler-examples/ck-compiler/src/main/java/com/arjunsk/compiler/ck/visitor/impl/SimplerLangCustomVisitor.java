package com.arjunsk.compiler.ck.visitor.impl;

import com.arjunsk.compiler.ck.domain.tree.nodes.grammer.impl.LetContext;
import com.arjunsk.compiler.ck.domain.tree.nodes.grammer.impl.ShowContext;
import com.arjunsk.compiler.ck.visitor.SimplerLangBaseVisitor;
import java.util.HashMap;
import java.util.Map;

/**
 * SimplerLang Custom Visitor Implementation.
 *
 * <p>NOTE: Here we write the logic for storing the `let` variable and displaying the `show` result.
 */
public class SimplerLangCustomVisitor extends SimplerLangBaseVisitor<Void> {

  private final Map<String, String> variableMap;

  public SimplerLangCustomVisitor() {
    super();
    variableMap = new HashMap<>();
  }

  @Override
  public Void visitLet(LetContext context) {
    this.variableMap.put(context.getVariableName().getText(), context.getVariableValue().getText());
    return super.visitLet(context);
  }

  @Override
  public Void visitShow(ShowContext context) {
    if (context.getIntegerValue() != null) {
      System.out.println(context.getIntegerValue().getText());
    } else if (context.getVariableName() != null) {
      System.out.println(this.variableMap.get(context.getVariableName().getText()));
    }
    return super.visitShow(context);
  }
}
