//package com.github.cloudcompilers.klotho.language;
//
//import com.github.cloudcompilers.klotho.language.psi.KlothoProperty;
//import com.google.common.collect.Lists;
//import com.intellij.openapi.project.Project;
//import com.intellij.openapi.util.text.StringUtil;
//import com.intellij.openapi.vfs.VirtualFile;
//import com.intellij.psi.PsiComment;
//import com.intellij.psi.PsiElement;
//import com.intellij.psi.PsiManager;
//import com.intellij.psi.PsiWhiteSpace;
//import com.intellij.psi.search.FileTypeIndex;
//import com.intellij.psi.search.GlobalSearchScope;
//import com.intellij.psi.util.PsiTreeUtil;
//import org.jetbrains.annotations.NotNull;
//
//import java.util.*;
//
//public class KlothoUtil {
//
//  /**
//   * Searches the entire project for Klotho language files with instances of the Klotho property with the given key.
//   *
//   * @param project current project
//   * @param key     to check
//   * @return matching properties
//   */
//  public static List<KlothoProperty> findProperties(Project project, String key) {
//    List<KlothoProperty> result = new ArrayList<>();
//    Collection<VirtualFile> virtualFiles =
//            FileTypeIndex.getFiles(KlothoFileType.INSTANCE, GlobalSearchScope.allScope(project));
//    for (VirtualFile virtualFile : virtualFiles) {
//      KlothoFile klothoFile = (KlothoFile) PsiManager.getInstance(project).findFile(virtualFile);
//      if (klothoFile != null) {
//        KlothoProperty[] properties = PsiTreeUtil.getChildrenOfType(klothoFile, KlothoProperty.class);
//        if (properties != null) {
//          for (KlothoProperty property : properties) {
//            if (key.equals(property.getKey())) {
//              result.add(property);
//            }
//          }
//        }
//      }
//    }
//    return result;
//  }
//
//  public static List<KlothoProperty> findProperties(Project project) {
//    List<KlothoProperty> result = new ArrayList<>();
//    Collection<VirtualFile> virtualFiles =
//            FileTypeIndex.getFiles(KlothoFileType.INSTANCE, GlobalSearchScope.allScope(project));
//    for (VirtualFile virtualFile : virtualFiles) {
//      KlothoFile klothoFile = (KlothoFile) PsiManager.getInstance(project).findFile(virtualFile);
//      if (klothoFile != null) {
//        KlothoProperty[] properties = PsiTreeUtil.getChildrenOfType(klothoFile, KlothoProperty.class);
//        if (properties != null) {
//          Collections.addAll(result, properties);
//        }
//      }
//    }
//    return result;
//  }
//
//  /**
//   * Attempts to collect any comment elements above the Klotho key/value pair.
//   */
//  public static @NotNull String findDocumentationComment(KlothoProperty property) {
//    List<String> result = new LinkedList<>();
//    PsiElement element = property.getPrevSibling();
//    while (element instanceof PsiComment || element instanceof PsiWhiteSpace) {
//      if (element instanceof PsiComment) {
//        String commentText = element.getText().replaceFirst("[!# ]+", "");
//        result.add(commentText);
//      }
//      element = element.getPrevSibling();
//    }
//    return StringUtil.join(Lists.reverse(result),"\n ");
//  }
//
//}
