// package com.github.cloudcompilers.klotho.language;
//
// import com.github.cloudcompilers.klotho.language.psi.KlothoProperty;
// import com.github.cloudcompilers.klotho.language.psi.KlothoTypes;
// import com.intellij.lang.ASTNode;
//
// public class KlothoPsiImplUtil {
//  public static String getKey(KlothoProperty element) {
//    ASTNode keyNode = element.getNode().findChildByType(KlothoTypes.KEY);
//    if (keyNode != null) {
//      // IMPORTANT: Convert embedded escaped spaces to klotho spaces
//      return keyNode.getText().replaceAll("\\\\ ", " ");
//    } else {
//      return null;
//    }
//  }
//
//  public static String getValue(KlothoProperty element) {
//    ASTNode valueNode = element.getNode().findChildByType(KlothoTypes.VALUE);
//    if (valueNode != null) {
//      return valueNode.getText();
//    } else {
//      return null;
//    }
//  }
// }
